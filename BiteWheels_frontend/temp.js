// JavaScript to show/hide the login modal and overlay

const loginButton = document.getElementById('login-button');
const loginModal = document.getElementById('login-modal');
const closeBtn = document.getElementById('close-button');
const overlay = document.getElementById('overlay');

loginButton.addEventListener('click', () => {
    loginModal.style.display = 'block';
    overlay.style.display = 'block';
});

closeBtn.addEventListener('click', () => {
    loginModal.style.display = 'none';
    overlay.style.display = 'none';
});

overlay.addEventListener('click', () => {
    loginModal.style.display = 'none';
    overlay.style.display = 'none';
});
