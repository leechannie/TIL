const express = require('express');
const cookieParser = require('cookie-parser');
const bodyParser = require('body-parser');
const path = require('path');
const msg = require('dialog');


const app = express();
const port = process.env.PORT;
app.set('port', process.env.PORT||8000);
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');
app.set('views', './views');

app.use(express.json()); 
app.use(express.urlencoded({extended: false}));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, './'))); //static을 현재 폴더로 연결 (그렇기에 이미지들은 img/로 한 번 더 폴더를 들어가야함)
const users = {}; //유저 정보 유지 
const title1 = {}; //사진 제목 정보 유지 
const title2 = {};
const title3 = {};
const title4 = {};
const QA = [ { num: "1", string: '혈액형은?',answer: 'O형'},
            { num: "2", string: '좋아하는 영화는?', answer: '리틀 포레스트'},
            { num: "3", string: '좋아하는 음식은?', answer: '잡채'},
            { num: "4", string: '좋아하는 연예인은?', answer: '정세운'},
            { num: "5", string: 'MBTI는?', answer: 'ENTJ'},
            { num: "6", string: '사는 곳은?', answer: '전라북도 군산시'},
            { num: "7", string: '가고싶은 직무는?', answer: '데이터 관리직무 혹은 데이터 기획자'}]
const str = {};

// 아이디와 비밀번호가 맞으면 main 페이지로 이동 
app.get('/', (req, res) => {
    console.log(req.cookies.start);
    if(req.cookies.start) //cookie-parser로 cookie 데이터를 넣어줌
        res.sendFile(path.join(__dirname,'./main.html')); 
    else
        res.redirect('/start');
});

// start.html로 가는 루틴
app.get('/start', (req, res) => {
    res.sendFile(path.join(__dirname,'./start.html')); 
});

// main.html로 가는 루틴
app.get('/home', (req, res) => {
    res.sendFile(path.join(__dirname,'./main.html')); 
});

// pug를 이용한 sns.pug 가는 루틴
app.get('/sns', (req, res) => {
    res.sendFile(path.join(__dirname,'./sns.html'));
});

// guest.html로 가는 루틴
app.get('/guest', (req, res) => {
    res.sendFile(path.join(__dirname,'./guest.html')); 
});

// gallery.html로 가는 루틴
app.get('/gallery', (req, res) => {
    res.sendFile(path.join(__dirname,'./gallery.html')); 
});

// qa.html로 가는 루틴
app.get('/QA', (req, res) => {
    res.sendFile(path.join(__dirname,'./qa.html')); 
});

// 이름이나 생일이 틀리면 틀렸음을 알리고 처음으로 가는 루틴
app.get('/retry', (req, res) => {
    msg.info("이름 혹은 생일이 틀렸어요❌");
    res.sendFile(path.join(__dirname,'./start.html')); 
});

// body-parser과 cookie-parser를 이용해 로그인 내용을 저장
app.post('/start', (req, res) => { 
    const {name, bday} = req.body //body-parser과 구조분해 할당
    console.log(req.body);

    if(name == '이찬희' & bday=='0213'){
        res.cookie('start', true, {  //cookie-parser
            maxAge: 60000, 
            httpOnly: true,
            secure: false,
            path:'/',
        } );
        res.redirect('/');
    } else{
        res.redirect('/retry'); //틀리면 retry로 가서 알림을 줌
    }
});

// guestUser에 users 데이터 전달 
app.get('/users', (req, res) => { 
    res.send(users);
});

// guest.html form에 담긴 name과 memo 데이터를 받음
app.post('/user', (req, res) => { 
    const {name, memo} = req.body;
    const id = Date.now(); 
    users[id] = {name, memo}; //users에 index로 현재 시간을 넣어 name과 memo 저장
    res.end();
});

// id를 기반으로 name과 memo 수정
app.put('/user/:id', (req, res) => { 
    const {name, memo} = req.body;
    users[req.params.id] = {name, memo};
    res.end();
});

// id를 기반으로 name과 memo 삭제 
app.delete('/user/:id', (req, res) => { 
    delete users[req.params.id];
    res.end();
});

// form1 관련 라우터로 묶기 
// form 정보 유지를 위해 각 form마다 메소드 따로 관리 
app.route('/title1')
    // galleyTitle에 데이터 전달요청 
    .get( (req, res) => {  
        res.send(title1);
    })
    // galleyTitle을 통해 form에 담긴 title1 가져오기 
    .post( (req, res) => {
        const a = req.body.title; //body-parser 사용
        title1.제목 = a;
        res.end();
});

// form2 관련 라우터로 묶기 
app.route('/title2')
    // galleyTitle에 데이터 전달요청 
    .get( (req, res) => {  
        //console.log(title2);
        res.send(title2);
    })
    // galleyTitle을 통해 form에 담긴 title 가져오기
    .post( (req, res) => {
        const a = req.body.title; //body-parser 사용
        title2.제목 = a;
        res.end();
});

// form3 관련 라우터로 묶기 
app.route('/title3')
    // galleyTitle에 데이터 전달요청 
    .get( (req, res) => {  
        //console.log(title3);
        res.send(title3);
    })
    // galleyTitle을 통해 form에 담긴 title 가져오기 
    .post( (req, res) => {
        const a = req.body.title; //body-parser 사용
        title3.제목 = a;
        res.end();
});

// form4 관련 라우터로 묶기 
app.route('/title4')
    // galleyTitle에 데이터 전달요청  
    .get( (req, res) => {  
        //console.log(title4);
        res.send(title4);
    })
    // galleyTitle을 통해 form에 담긴 title 가져오기 
    .post( (req, res) => {
        const a = req.body.title; //body-parser 사용
        title4.제목 = a;
        res.end();
});

// qa.html 관련 라우터로 묶기
app.route('/answer')
    .get( (req, res) => { 
        // qaUser.js에 데이터 전달요청 
        let q = "질문지에 없는 질문입니다."
        QA.forEach ((dev) => { //forEach로 번호나 질문이랑 같은지 확인해 답을 반환
            if (dev.num === str.질문 || dev.string === str.질문 ){
                q = dev.answer;
            }
        }); 
        res.send(q);
    })
    .post( (req, res) => {
        // qaUser을 통해 form에 담긴 질문 가져오기  
        const qu = req.body.question; //body-parser 사용
        str.질문 = qu;
        res.end();
});

// 오류 처리 
app.use ((err, req, res, next) => {
 res.status(401).send(err.message);
}); 

app.listen(app.get('port'), () => {
    console.log(`App liestening at http://localhost:${app.get('port')}`)
});