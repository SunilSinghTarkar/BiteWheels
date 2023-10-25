let container = document.getElementById("container1");
container.innerText = "Hello this is sunil";
let extradisc = 1;
let cartId=1;
//This is a function for creating dynamic Menu items.
let ctotal = document.getElementById("sbtotal");
let discount = document.getElementById("discount");
let pretotal = document.getElementById("pretotal");
let saving = document.getElementById("tsaving");

function createItems(items) {

    container.innerHTML = null;
    let totalPrice = 0;
    items.forEach(element => {
        totalPrice += element.subtotal;
        let div1 = document.createElement("div");
        div1.classList.add("item");
        let image = document.createElement("img");
        image.src = element.item.imageUrl;
        let title = document.createElement("h2");
        title.innerText = element.item.name;

        let div2 = document.createElement("div");
        div2.classList.add("price-stock");

        let price = document.createElement("h2");
        price.innerText = "Rs " + element.subtotal;

        let div4 = document.createElement("div");
        div4.classList.add("quantity")
        let descbtn = document.createElement("button");
        descbtn.addEventListener("click", function () {
           
            if (element.quantity > 1) descQuantity(element.orderItemId);

        });
        descbtn.innerText = "-";
        let quantity = document.createElement("p");
        quantity.innerText = element.quantity;
        let incbtn = document.createElement("button");
        incbtn.innerText = "+";
        incbtn.addEventListener("click", function () {
        
            if (element.quantity < 5) incQuantity(element.orderItemId);
        });
        div4.append(descbtn, quantity, incbtn);

        div2.append(price, div4);

        let div3 = document.createElement("div");
        div3.classList.add("addtocartbtn");
        let btn = document.createElement("button");
        btn.innerText = "Remove"
        btn.addEventListener("click", function () {
            removeItem(element.orderItemId);
        })
        div3.append(btn);

        div1.append(image, title, div2, div3);
        container.append(div1);
    });

    ctotal.innerText = "Rs" + totalPrice;
    discount.innerText = "10%";
    saving.innerText = "Rs" + Math.ceil(((totalPrice / 10) + (totalPrice - totalPrice * extradisc)));
    pretotal.innerText = "Rs" + Math.floor((totalPrice - totalPrice / 10) * extradisc);
}


/*Function for fetching dynamically cart itmes*/
async function fetchMenuData() {
    try {
        let response = await fetch(`http://localhost:8080/carts/${cartId}`);

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        let data = await response.json();
        createItems(data.orderItems);
    } catch (error) {
        console.error("Error:", error);
    }
}
fetchMenuData();


//function for descrease Quantity
async function descQuantity(orderId) {
    try {
        let response = await fetch(`http://localhost:8080/carts/descQuantity/${orderId}`, { method: "PATCH" });
        if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
        fetchMenuData();
    }
    catch (error) {
        console.error("Error:", error);
    }
}
//function for Increase Quantity
async function incQuantity(orderId) {
    try {
        let response = await fetch(`http://localhost:8080/carts/incQuantity/${orderId}`, { method: "PATCH" });
        if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
        fetchMenuData();
    }
    catch (error) {
        console.error("Error:", error);
    }
}
//Function for remove Items
async function removeItem(orderId) {
    try {
        let response = await fetch(`http://localhost:8080/carts/removeOrderItems/${orderId}`, { method: "DELETE" });
        if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
        fetchMenuData();
    }
    catch (error) {
        console.error("Error:", error);
    }
}
// Applying coupon part starts from here
let applybtn = document.getElementById("apply")
applybtn.addEventListener("click", function () {
    let inputdiv = document.getElementById("coupon-input");
    applybtn.style.display = "none";
    inputdiv.style.display = "block";
})
let applycouponbtn = document.getElementById("couponapply")
let coupontext = document.getElementById("coupontext")

applycouponbtn.addEventListener("click", (() => {
    if (coupontext.value.toLowerCase() == "sunil30") {
        extradisc = 0.7;
        coupontext.value = "Coupon code applied";
        coupontext.style.color = "green";
        coupontext.style.borderColor = "green";
    }
    else {
        coupontext.placeholder = "Invalid Coupon code";
        coupontext.style.color = "red";
    }
    fetchMenuData();
}));


