const http = require('http');

http.createServer((req, res) => {
    console.log(req.url, req.headers.cookie);
    res.writeHead(200, {'Set-Cookie' : ['class-AdvWeb', 'credits=3']}); //헤더에 쿠키 정보를 저장해 웹브라우저에 저장
    res.write('Cookie testing');
    res.end('......');
})
.listen(3001, () => {
    console.log('3001번 포트에서 JY 서버 대기중... ');
})