// 폼1에 값이 있으면 가져와 gallery.html의 title1이라는 객체에 넣어줘 제목을 바꿀 수 있게함 
async function getTitle1(){
    try {
        getTitle2();
        const res = await axios.get('/title1');
        const users = res.data;

        if (users.제목 != undefined){
        const title1 = document.getElementById('title1');
        const new_title = document.createElement('p');
        new_title.innerHTML = users.제목; 
        title1.innerHTML = ""; 
        title1.appendChild(new_title);
        }
    }catch(err){
        console.error(err);
    }
}

// 폼2의 값을 가져옴 (폼1과 알고리즘 동일)
async function getTitle2(){
    try {
        getTitle3();
        const res = await axios.get('/title2');
        const users = res.data;

       if (users.제목 != undefined){
        const title2 = document.getElementById('title2');
        const new_title2 = document.createElement('p');
        new_title2.innerHTML = users.제목; 
        title2.innerHTML = ""; 
        title2.appendChild(new_title2);
       }
    }catch(err){
        console.error(err);
    }
}

// 폼3의 값을 가져옴 (폼1과 알고리즘 동일)
async function getTitle3(){
    try {
        getTitle4();
        const res = await axios.get('/title3');
        const users = res.data;

       if (users.제목 != undefined){
        const title3 = document.getElementById('title3');
        const new_title3 = document.createElement('p');
        new_title3.innerHTML = users.제목; 
        title3.innerHTML = ""; 
        title3.appendChild(new_title3);
       }
    }catch(err){
        console.error(err);
    }
}

// 폼4의 값을 가져옴 (폼1과 알고리즘 동일)
async function getTitle4(){
    try {
        const res = await axios.get('/title4');
        const users = res.data;

        if (users.제목 != undefined){
        const title4 = document.getElementById('title4');
        const new_title4 = document.createElement('p');
        new_title4.innerHTML = users.제목; 
        title4.innerHTML = ""; 
        title4.appendChild(new_title4);
        }
    }catch(err){
        console.error(err);
    }
}
window.onload = getTitle1;

//폼1 제출시 실행
document.getElementById('form1').addEventListener('submit', async(e) =>{
    e.preventDefault();

    //title 객체를 가져옴
    const title = e.target.title.value;
    if (!title){
        return alert('입력하세요');
    }
    try {
        await axios.post('/title1', {'title':title});
        getTitle1();
    }catch (err){
        console.error(err);
    }
    //입력 form 초기화
    e.target.title.value="";
});

//폼2 제출시 실행 (폼1과 알고리즘 동일)
document.getElementById('form2').addEventListener('submit', async(e) =>{
    e.preventDefault();

    const title = e.target.title.value;
    if (!title){
        return alert('입력하세요');
    }
    try {
        await axios.post('/title2', {'title':title});
        getTitle2();
    }catch (err){
        console.error(err);
    }
    e.target.title.value="";
});


//폼3 제출시 실행 (폼1과 알고리즘 동일)
document.getElementById('form3').addEventListener('submit', async(e) =>{
    e.preventDefault();

    const title = e.target.title.value;
    if (!title){
        return alert('입력하세요');
    }
    try {
        await axios.post('/title3', {'title':title});
        getTitle3();
    }catch (err){
        console.error(err);
    }
    e.target.title.value="";
});

//폼4 제출시 실행 (폼1과 알고리즘 동일)
document.getElementById('form4').addEventListener('submit', async(e) =>{
    e.preventDefault();

    const title = e.target.title.value;
    if (!title){
        return alert('입력하세요');
    }
    try {
        await axios.post('/title4', {'title':title});
        getTitle4();
    }catch (err){
        console.error(err);
    }
    e.target.title.value="";
});