
let form = document.getElementById('user-form');

form.addEventListener('submit', async function (event) {
    event.preventDefault();

    let name = document.getElementById('name').value;
    let email = document.getElementById('email').value;
    let phone = document.getElementById('phone').value;
    let userName = document.getElementById('userName').value;
    let password = document.getElementById('password').value;
    let address = document.getElementById('address').value;
    let userData = {
        name,
        email,
        phone,
        userName,
        password,
        address,
    }
    console.log('User Data:', userData);
    try {
        let response = await fetch('http://localhost:8080/users/save', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        })
        let result = await response.json();
        console.log(result);
        console.log("CartId", result.cart.cartId);
        localStorage.setItem("userId", result.userId);
        localStorage.setItem("userName", result.name);
        localStorage.setItem("cartId", result.cart.cartId);
        window.location.href = "/login.html";
    }
    catch (error) {
        console.error(error);
    }
});

