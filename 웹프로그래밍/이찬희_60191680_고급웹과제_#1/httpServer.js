const http = require('http');
const fs = require('fs').promises;

const hostname = '127.0.0.1';
const port = 3001;

//피자 이름을 적으면 가격을 보여주게 배열로 저장
const kind = [ { name: '페퍼로니 피자', price: '7000원'},
                    { name: '고구마 피자', price: '8000원'},
                    { name: '감자 피자', price: '8000원' },
                    { name: '치즈 피자', price: '7000원'},
                    { name: '불고기 피자', price: '9000원' },
                    { name: '고르곤졸라', price: '10000원' }]
let find = { };

http.createServer(async (req, res) => {
    try {
        //get 요청
        if (req.method === 'GET'){
            if(req.url === '/'){
                console.log('GET /');
                const data = await fs.readFile('./home.html'); //home.html로 이동
                res.writeHead(200, {'Content-Type' : 'text/html; charset=utf-8'});
                return res.end(data);
            } else if (req.url === '/pizza'){
                console.log('GET /pizza');
                const data = await fs.readFile('./pizza.html'); //pizza.html로 이동 
                res.writeHead(200, {'Content-Type' : 'text/html;  charset=utf-8'});
                return res.end(data);
            } else if (req.url === '/answer'){ //이름을 치면 가격을 알려주게 함
                console.log('GET /answer: ');
                let answer = '그런 피자는 팔지 않아요!';
                kind.forEach ((dev) => {
                    if (dev.name === find.name){
                        answer = dev.price;
                    }
                });
                console.log(`GET / answer: ${find.name}-${answer}`);
                res.writeHead(201,{'Content-Type': 'text/plain; charset=utf-8'} );
                return res.end(answer);
            }
            try{
                const data = await fs.readFile(`.${req.url}`);
                return res.end(data);
            }catch (err){
                console.error(err);
                res.writeHead(404,{'Content-Type': 'text/plain; charset=utf-8'} );
                return res.end ('NOT FOUND');
            }
            //post 요청
        } else if (req.method === 'POST') {
                if (req.url === '/webtech'){
                    req.on('data', (data) => {
                        console.log('POST /webtech data:', data.toString());
                        find = JSON.parse(data);
                        res.writeHead(201, {'Content-Type': 'text/plain; charset=utf-8'});
                        return res.end('ok');
                    })
                }
            } 
        
    }catch (err){
        console.error(err);
        res.writeHead(500, {'Content-Type': 'text/plain; charset=utf-8'});
        res.end(err.message);
    }
})
.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}/`);
});