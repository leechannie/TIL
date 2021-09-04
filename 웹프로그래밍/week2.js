// // 1. 프로미스 생성
// const promise = new Promise ((resolve, reject) => {
//     console.log('파일 읽기 시작...');
//     setTimeout(() => {
//         let read = true;
//         if (read) resolve('파일 읽기 성공');
//         else        reject(new Error('파일 읽기 실패'));
//     }, 2000);
// });

// // 2. then, catch, finally
// promise
//     .then(value => {
//         console.log(value);
//     })
//     .catch(error => {
//         console.log(error);
//     })
//     .finally(()=>{
//         console.log('finally');
//     });

// // 3. 프로미스 chaining
// const fetchData = new Promise ((resolve, reject) => {
//     setTimeout(() => resolve('Carrot'), 1000);
// });

// fetchData
// .then(data => data+' Cheese')
// .then(data => data+' Cake')
// .then(data => {
//     return new Promise ((resolve, reject) => {
//         setTimeout(() => resolve(data+'!'), 1000);
//     });
// })
// .then (data => console.log(data))
// .catch(error => {
//     console.log(error);
// });

function loginUser(id, password){
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log('사용자 정보 얻음');
            resolve ({userId: id});
        }, 3000);
    });
}
function getUserVideo(id){
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve (['video1','video2','video3' ]);
        }, 2000);
    });
}
function videoDetails(video){
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve ('비디오 제목은 ...');
        }, 2000);
    });
}
loginUser('jypark', 123456)
.then(user => {
    console.log(`${user.userId}님 환영합니다.`);
    return getUserVideo(user.id);
})
.then(videos => {
    console.log(videos);
    return videoDetails(videos[0]);
})
.then(details => console.log(details));