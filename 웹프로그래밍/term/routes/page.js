const express = require('express');
const { isLoggedIn, isNotLoggedIn } = require('./middlewares');
const { Post, User, Hashtag } = require('../models');

const router = express.Router();

router.use((req, res, next) => {
  res.locals.user = req.user;
  next();
});

router.get('/profile',  async (req, res, next) => {
  try {
    const po = await Post.findAll({ //게시글도 포함해 다 가져오게 함 (배열형식)
      include: {
        model: User,
        attributes: ['id', 'nick'],
      },
      order: [['createdAt', 'DESC']],
    });
    res.render('profile', {
      title: '내정보 - 여행 예약 사이트 60191680 이찬희',
      twits: po, //배열 형식 
    });
  } catch (err) {
    console.error(err);
    next(err);
  }
});

router.get('/join', isNotLoggedIn, (req, res) => {
  res.render('join', { title: '회원가입 - 여행 예약 사이트 60191680 이찬희' });
});
 
//모든 데이터를 가져옴 
router.get('/', async (req, res, next) => {
  try {
    const posts = await Post.findAll({ //게시글도 포함해 다 가져오게 함 (배열형식)
      include: {
        model: User,
        attributes: ['id', 'nick'],
      },
      order: [['createdAt', 'DESC']],
    });
    res.render('main', {
      title: '여행 예약 사이트 60191680 이찬희',
      twits: posts, //배열 형식 
    });
  } catch (err) {
    console.error(err);
    next(err);
  }
});

//모든 데이터를 가져옴 
router.get('/order', async (req, res, next) => {
  try {
    const pots = await Post.findAll({ //게시글도 포함해 다 가져오게 함 (배열형식)
      include: {
        model: User,
        attributes: ['id', 'nick'],
      },
      order: [['createdAt', 'ASC']],
    });
    res.render('main', {
      title: '여행 예약 사이트 60191680 이찬희',
      twits: pots, //배열 형식 
    });
  } catch (err) {
    console.error(err);
    next(err);
  }
});

router.get('/hashtag', async (req, res, next) => {
  const query = req.query.hashtag;
  if (!query) {
    return res.redirect('/');
  }
  try {
    const hashtag = await Hashtag.findOne({ where: { title: query } });
    let posts = [];
    if (hashtag) {
      posts = await hashtag.getPosts({ include: [{ model: User }] });
    }

    return res.render('main', {
      title: `${query} | 여행 예약 사이트 60191680 이찬희`,
      twits: posts,
    });
  } catch (error) {
    console.error(error);
    return next(error);
  }
});

router.get('/board', function(req, res, next) {
  models.edit.findAll({
    where: {writer: "victolee"}
  })
  .then( result => {
    res.render("show", {
      posts: result
    });
  })
  .catch(function(err){
    console.log(err);
  });
});

router.post('/board', function(req, res, next) {
  let body = req.body;

  models.edit.create({
    title: body.inputTitle,
    writer: body.inputWriter
  })
  .then( result => {
    console.log("데이터 추가 완료");
    res.redirect("/board");
  })
  .catch( err => {
    console.log("데이터 추가 실패");
  })
});

router.get('/edit/:id', function(req, res, next) {
  let postID = req.params.id;

  models.edit.findOne({
    where: {id: postID}
  })
  .then( result => {
    res.render("edit", {
      post: result
    });
  })
  .catch( err => {
    console.log("데이터 조회 실패");
  });
});

router.put('/board/:id', function(req, res, next) {
  let  postID = req.params.id;
  let body = req.body;

  models.edit.update({
    title: body.editTitle,
    writer: body.editWriter
  },{
    where: {id: postID}
  })
  .then( result => {
    console.log("데이터 수정 완료");
    res.redirect("/board");
  })
  .catch( err => {
    console.log("데이터 수정 실패");
  });
});
router.delete('/board/:id', function(req, res, next) {
  let postID = req.params.id;

  models.edit.destroy({
    where: {id: postID}
  })
  .then( result => {
    res.redirect("/board")
  })
  .catch( err => {
    console.log("데이터 삭제 실패");
  });
});
module.exports = router;