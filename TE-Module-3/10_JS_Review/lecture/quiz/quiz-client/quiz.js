function fetchRandomQuestion(){
    fetch('http://localhost:8080/questions/random')
    .then(response => response.json())
    //once a get a response then make it json format
    //then access the data from response
    .then(data =>{
        console.log(data)
        const container = document.getElementById('container');
        const pTag = container.querySelector('p');
        pTag.innerText = data.question;
    })
}

document.addEventListener('DOMContentLoaded', () => {
    const randomBtnRef = document.getElementById('btnGetRandomQuestion');
    randomBtnRef.addEventListener('click', fetchRandomQuestion)
})