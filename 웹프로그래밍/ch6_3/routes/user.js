const express = require('express');

const router = express.Router();

// GET /user 라우터
router.get('/', (req, res) => {
  res.send('Hello, User');
});

// GET /nodejs 라우터
router.get('/nodejs', (req, res) => {
  res.send('Hello, NodeJs Class User!');
});

// GET /Javascript 라우터
router.get('/javascript', (req, res) => {
  res.send('Hello, Javascript Class User');
});

// GET /:name 라우터
router.get('/:name', (req, res) => {
  res.send(`Hello, User ${resq.params.name}`);
});

module.exports = router;
