let userId=localStorage.getItem("userId");
userId=3;
console.log(userId);

document.getElementById('driverForm').addEventListener('submit', async function (event) {
    event.preventDefault(); 

    let age = document.getElementById('age').value;
    let currLocation = document.getElementById('currLocation').value;
    let bikeNo = document.getElementById('bikeNo').value;
    let bikeName = document.getElementById('bikeName').value;
    let licenseNo = document.getElementById('licenseNo').value;
    let aadharNumber = document.getElementById('aadharNo').value;
    let driverData = {
        age,
        currLocation,
        bikeNo,
        bikeName,
        licenseNo,
        aadharNumber
    };
    console.log(driverData)
    let apiUrl = `http://localhost:8080/users/becomerider/${userId}`;
    let headers = {
        'Content-Type': 'application/json',
    };

    let requestOptions = {
        method: 'POST',
        headers: headers,
        body: JSON.stringify(driverData)
    };

    try {
        let response = await fetch(apiUrl, requestOptions);
        if (!response.ok) throw new Error('Network response was not ok');
        let data = await response.json();
        console.log('Data submitted. Server response:', data);
    } catch (error) {
        console.error('Submission error:', error);
    }
});