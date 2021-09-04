// 피자 입력시 가격을 얻는 함수
async function getAnswer() {
    try{
        const res = await axios.get('/answer');
        const list = res.data;
        const answer = document.getElementById('answer');
        answer.textContent = list; 
    }catch (err){
        console.error(err);
    }
}

// 폼 제출시 실행
document.getElementById('form').addEventListener('submit', 
async (e) => {
    e.preventDefault();
    const name = e.target.webtech.value;
    if (!name){
        return alert('피자 이름을 기입해주세요!');
    }
    try {
        await axios.post('/webtech', {name});
        getAnswer();
    }catch (err){
        console.error(err);
    }
    e.target.webtech.value = '';
});