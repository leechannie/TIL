const express = require('express');
const path  = require('path');
const morgan = require('morgan');

const SocketIO = require('socket.io');

const app = express();
app.set('port', process.env.PORT || 8005);
app.use(morgan('dev'));

app.get('/', (req, res) => {
    res.sendFile(__dirname + '/index.html');
});

const server = app.listen(app.get('port'), () => {
    console.log(app.get('port'), '번 포트에서 대기');
});

const io = SocketIO(server);

//연결시
io.on('connection', (socket) => {
    console.log('새로운 클라이언트 접속', socket.id);

    // 연결 종료 
    socket.on('disconnect', () => {
        console.log('클라이언트 접속 해체', socket.id);
    });

    // 3초마다 메시지
    setInterval(() => {
        socket.emit('news', 'Hello. Socket. IO Client!');
    }, 3000);

    //클라이언트 메시지 수신
    socket.on('reply', (data) => {
        console.log(data);
    });
});