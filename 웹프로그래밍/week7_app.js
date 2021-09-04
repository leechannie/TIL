const dotenv = require('dotenv');
dotenv.config();
const express = require('express');
const path = require('path');
const morgan  = require('morgan');
const cookieParser = require('cookie-parser');
const session = require('express-session');

const app = express();
app.set('port', process.env.PORT||3001); //서버 사용하는 모든 사람이 공용으로 사용

app.use ( morgan ('dev'));
app.use(express.static(path.join(__dirname, 'week7'))); //직접 파일 이름을 찾음
app.use(express.json());
app.use(express.urlencoded({extended: false}));
app.use(cookieParser(process.env.COOKIE_secret));
app.use(session({
    resave: false,
    saveUninitialized: true,
    secret: process.env.COOKIE_secret,
    cookie: {
        httpOnly: true,
        secure: false,
        maxAge: 600000
    },
    name: 'session-cookie' //쿠키 네임 설정
}) );

const users = {}; //유저 정보 유지 

app.use((req, res, next) =>{
    console.log(req.session);
    console.log(req.sessionID);
    req.session.views = (req.session.views || 0) + 1;
    next();
} )
app.get('/', (req, res) => {
    console.log(req.signedCookies);
    if(req.signedCookies.admit) 
    res.send('<h1>Login Success</h1>');
    else
    res.redirect('/login');
});

app.get('/login', (req, res) => {
    res.sendFile(path.join(__dirname,'./week7/login.html')); //다양한 데이터 전송 가능
});

app.get('/admit', (req, res) => { //query로 전송 
    console.log(req.query);
    console.log(req.body);
    res.send(`username: ${req.query.login} <br>
              password: ${req.query.password}` );
});

app.post('/admit', (req, res) => { //formdata로 전송 그래서 바디파서 사용
    const {login, password} = req.body //구조분해 할당
    //console.log(req.body);
    
    if(login == 'guest' & password=='7777'){
        res.cookie('admit', true, { //admit은 키 value를 true로 준거 
            maxAge: 60000,
            httpOnly: true,
            secure: false,
            path:'/',
            signed: true
        } );
        // res.clearcookie('admit', {userType: 'guest', authorized: true},{
        //     httpOnly: true,
        //     path:'/'
        // } );
        res.redirect('/');
    } else{
        res.redirect('/login');
    }
});

app.get('/user', (req, res) => { 
    res.sendFile(path.join(__dirname, './week7/user.html'));
});

app.get('/users', (req, res) => { 
    res.send(users);
});

app.post('/user', (req, res) => { 
    const {name, memo} = req.body;
    const id = Date.now();
    users[id] = {name, memo};
    res.end();
});

app.put('/user/:id', (req, res) => { 
    const {name, memo} = req.body;
    users[req.params.id] = {name, memo};
    res.end();
});

app.delete('/user/:id', (req, res) => { 
    delete users[req.params.id];
    res.end();
});

app.use ((err, req, res, next) => {
 res.status(401).send(err.message);
}); 

app.listen(app.get('port'), () => {
    console.log(`App liestening at http://localhost:${app.get('port')}`)
})
