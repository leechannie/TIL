// qa.html을 통해 들어온 질문의 답을 요청
async function getAnswer() {
    try{
       const res = await axios.get('/answer');
       const ans = res.data;
       const answer = document.getElementById('answer');
       answer.textContent = ans;
    }catch (err){
        console.error(err);
    }
}

// 폼 제출시 실행
document.getElementById('form').addEventListener('submit', 
async (e) => {
    e.preventDefault();
    const question = e.target.question.value;
    if (!question){
        return alert('질문을 입력해주세요!');
    }
    try {
        await axios.post('/answer', {'question': question});
        getAnswer();
    }catch (err){
        console.error(err);
    }
});