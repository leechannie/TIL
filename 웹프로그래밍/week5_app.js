const express = require('express');
const path = require('path');
const morgan  = require('morgan');

const app = express();

app.set('port', process.env.PORT||3000);

app.use ( morgan ('dev'));
app.use(express.static(path.join(__dirname, 'week4'))); //직접 파일 이름을 찾음

app.get('/', (req, res) => {
    //res.send("Hello, Express!")
    res.sendFile(path.join(__dirname,'./week5_index.html')); //다양한 데이터 전송 가능
})

 app.get('/about', (req, res, next) => {
     console.log('about 1');
     if (req.headers.cookie) next();
     else throw new Error ('Invalid Cookie~');
 }, (req, res) => {
     let obj = {product: 'coke', price: '800'};
     res.send(obj);

 });


 app.use ((req, res, next) => {
    console.log('모든 요청에 대해 실행하는 미들웨어'); //무조건 실행
    req.user = "BTS";
    next();
})

app.use ((req, res, next) => {
    res.day = "Easter";
    next();
})

app.use('/users/:userId', function(req, res){
    // res.send(`User ${req.params.userId}`);
    res.send(`${req.user} send User ${req.params.userId} eggs at ${res.day}`);
 })


app.get('*', (req, res) => {
    res.sendStatus(404)
})

app.use ((err, req, res, next) => {
 res.status(401).send(err.message);
}); 

app.listen(app.get('port'), () => {
    console.log(`App liestening at http://localhost:${app.get('port')}`)
})
