const chart = document.querySelector("#chart").getContext('2d');

// 새로운 차트 객체 생성
new Chart(chart, {
    type: 'line',
    data: {
        labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],

        datasets: [
            {
                label: '매출',
                data: [100, 120, 180, 250, 380, 420, 550, 640, 770, 890, 1050, 1200],
                borderColor: 'red',
                borderWidth: 2
            }
        ]
    },
    options: {
        responsive: true
    }
})

// show or hide sidebar
const menuBtn = document.querySelector('#menu-btn');
const closeBtn = document.querySelector('#close-btn');
const sidebar = document.querySelector('aside');

menuBtn.addEventListener('click', () => {
    sidebar.style.display = 'block';
})

closeBtn.addEventListener('click', () => {
    sidebar.style.display = 'none';
})

// change theme
const themeBtn = document.querySelector('.theme-btn');

themeBtn.addEventListener('click', () => {
    document.body.classList.toggle('dark-theme');

    themeBtn.querySelector('span:first-child').classList.toggle('active');
    themeBtn.querySelector('span:last-child').classList.toggle('active');
})