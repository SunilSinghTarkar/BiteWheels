document.getElementById('loginForm').addEventListener('submit', async function (event) {
    event.preventDefault();

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let userData = {
        username,
        password
    };
    console.log(userData);
    let apiUrl = 'https://example.com/api/login';
    let headers = {
        'Content-Type': 'application/json',
    };

    let requestOptions = {
        method: 'POST',
        headers: headers,
        body: JSON.stringify(userData)
    };

    try {
        let response = await fetch(apiUrl, requestOptions);
        if (!response.ok) throw new Error('Network response was not ok'); 
        let data = await response.json();
        console.log('Login successful. Server response:', data);   
    } catch (error) {
        console.error('Login error:', error);
    }
});