let container1=document.getElementById("container1");
let container2=document.getElementById("container2");

container1.addEventListener("click",restaurantPage);
container2.addEventListener("click",restaurantPage);

function restaurantPage(){
    window.location.href="restaurant.html";
}
