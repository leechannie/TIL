// nunjucks 사용 & multer 미들웨어 사용

// multer: 이미지, 동영상 등 여러가지 파일들을 멀티파트 형식으로 업로드할 때 사용하는 미들웨어
// 멀티파트 형식: encrype이 multipart/form-data인 폼을 통해 업로드하는 데이터의 형식

const express = require('express');
const morgan = require('morgan');
const path = require('path');
const fs = require('fs');

// 1) nunjucks & multer 미들웨어를 import
const nunjucks = require('nunjucks');
const multer = require('multer');

const app = express();
app.set('port', process.env.PORT || 3000);
app.set('view engine', 'html');

// 2) nunjucks 설정
nunjucks.configure('views', { //views 폴더에 넣어둘거다 
    express: app,
    autoscape: true,
    // watch: true // ==> 이것 있으면 오류 발생
});

app.use(morgan('dev'));
app.use(express.urlencoded({ extended: false }));

// 3) 서버 시작전에 upload할 서버의 폴더 생성
try {
    fs.readdirSync('uploads'); //동기식 처리
} catch (error) {
    console.error('uploads 폴더가 없어 uploads 폴더를 생성합니다.');
    fs.mkdirSync('uploads');
}

// 4) multer의 diskStorage()로 storage 객체 생성
const storage = multer.diskStorage({ //공간 객체 만들기 
    destination: function (req, file, cb) {
        cb(null, 'uploads');
    },
    filename: function (req, file, cb) {
        const ext = path.extname(file.originalname);
        cb(null, path.basename(file.originalname, ext) + Date.now() + ext);
    }
})

// 5) multer() 호출해서 upload 객체 생성
const upload = multer({
    storage: storage,
    limits: { fileSize: 5 * 1024 * 1024 } //파일 크기 제한 
});

// 참고: 임의의 파일 이름으로 upload 파일 생성
// const upload = multer( { dest: 'uploads/'} );

app.get('/upload', (req, res) => {
    res.render('multipart', { title: 'File Upload' });
});

// 6), 7), 8) 중 1개씩만 두고 나머지는 주석 처리 후 실행

// 6) 1개 파일 업로드 : multer의 미들웨어 single() 사용
app.post('/upload', upload.single('image'), (req, res) => {
    console.log(req.file, req.body);
    res.send('Uploaded!');
});

// 7) 여러 파일 업로드 : multer의 미들웨어 array() 사용 //field할 때는 없애야함
app.post('/upload', upload.array('image'), (req, res) => {
    console.log(req.files, req.body);
    res.send('Many Uploaded!');
});

// 8) 여러 input 태그와 name으로 여러 파일 업로드 : multer의 미들웨어 fields() 사용
app.post('/upload', upload.fields([{ name: 'image1' },
                                    { name: 'image2' },
                                    { name: 'image3' }]), (req, res) => {
    console.log(req.files.image1); // 업로드 정보를 req.files.image1에 넣어줌
    console.log(req.files.image2); // 업로드 정보를 req.files.image2에 넣어줌
    console.log(req.files.image3); // 업로드 정보를 req.files.image3에 넣어줌
    res.send('Multiple Uploaded!');
});

// 9) 파일 업로드 안하는 경우: none()
app.post('/upload', upload.none(), (req, res) => {
    console.log(req.body.title);
    res.send('ok');
});

app.use((err, req, res, next) => {
    res.status(401).send(err.message);
});

app.listen(app.get('port'), () => {
    console.log(`App listening at http://localhost:${app.get('port')}`)
});