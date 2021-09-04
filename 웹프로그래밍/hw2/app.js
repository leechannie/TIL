const express = require('express');
const path = require('path');
const morgan = require('morgan');
const nunjucks = require('nunjucks');
const bodyParser = require('body-parser');

const { sequelize } = require('./models');
const indexRouter = require('./routes');
const usersRouter = require('./routes/users');
const commentsRouter = require('./routes/comments');

const app = express();
app.set('port', process.env.PORT || 3001);
app.use(express.static(path.join(__dirname, './')));
app.set('view engine', 'html');
nunjucks.configure('views', {
  express: app,
  watch: true,
});
const title1 = {}; //사진 제목 정보 유지 
// ORM Sequelize 사용
sequelize.sync({ force: false })
  .then(() => {
    console.log('데이터베이스 연결 성공');
  })
  .catch((err) => {
    console.error(err);
  });

   
app.use(morgan('dev'));
app.use(express.static(path.join(__dirname, 'public')));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

// guestUser에 users 데이터 전달 
app.get('/u', (req, res) => { 
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
app.use('/', indexRouter);
app.use('/users', usersRouter);
app.use('/comments', commentsRouter);

app.use((req, res, next) => {
  const error =  new Error(`${req.method} ${req.url} 라우터가 없습니다.`);
  error.status = 404;
  next(error);
});

app.use((err, req, res, next) => {
  res.locals.message = err.message;
  res.locals.error = process.env.NODE_ENV !== 'production' ? err : {};
  res.status(err.status || 500);
  res.render('error');
});

app.listen(app.get('port'), () => {
  console.log(`App liestening at http://localhost:${app.get('port')}`);
});