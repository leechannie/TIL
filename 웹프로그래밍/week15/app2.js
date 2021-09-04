const express = require('express');
const path  = require('path');
const morgan = require('morgan');

const SocketIO = require('socket.io');

const app = express();
app.set('port', process.env.PORT || 8005);
app.use(morgan('dev'));

app.get('/', (req, res) => {
    res.sendFile(__dirname + '/index2.html');
});

const server = app.listen(app.get('port'), () => {
    console.log(app.get('port'), '번 포트에서 대기');
});

const io = SocketIO(server);

//연결시
io.on('connection', (socket) => {
    console.log('새로운 클라이언트 접속', socket.id);

    io.to(socket.id).emit('welcom', '(From Server) welcome!'+socket.id);
    // 연결 종료 
    socket.on('disconnect', () => {
        console.log('클라이언트 접속 해체', socket.id);
    });

    socket.on('echopush', (msg) => {
        // brodcast 통신: 자신을 제외한 모든 소켓에 이벤트
       // socket.broadcast.emit('echo', msg);
        // 현재 연결된 모든 소켓에 이벤트
        io.emit('echo', msg); 
        // 소켓 하나에만 이벤트 
        //socket.emit('echo', msg)
    });
});