// guestUser에 users 데이터 전달 
app.get('/u', (req, res) => { 
    console.log('d')
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