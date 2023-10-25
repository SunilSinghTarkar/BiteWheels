let container = document.getElementById("container1");

let userId = 1;
let cartId = 1;
let menuId = 1;
let userName = "Rama";

let home = document.getElementsByClassName("logo")[0];
home.addEventListener("click", function () {
    window.location.href = "index.html";
});


//This is a function for creating dynamic Menu items.
function createItems(items) {
    container.innerHTML = null;
    items.forEach(element => {
        let div1 = document.createElement("div");
        div1.classList.add("item");
        let image = document.createElement("img");
        image.src = element.imageUrl;
        let title = document.createElement("h2");
        title.innerText = element.name;

        let div2 = document.createElement("div");
        div2.classList.add("price-stock");
        let price = document.createElement("h2");
        price.innerText = "Rs " + element.price;
        let isAvl = document.createElement("p");
        if (element.availability) isAvl.innerText = "In Stock";
        else {
            isAvl.innerText = "Out of Stock";
            isAvl.style.color = "red";
        }
        div2.append(price, isAvl);

        let div3 = document.createElement("div");
        div3.classList.add("addtocartbtn");
        let btn = document.createElement("button");
        btn.innerText = "Add to Cart";
        const icon = document.createElement('i');
        icon.className = 'fas fa-check-circle';
        icon.style.display = 'none';
        icon.style.padding = "5px";

        btn.appendChild(icon);

        btn.addEventListener("click", async function () {
            if (element.availability) {
                let check = await checkInCart(element.itemId);
                if (check) alert(`Available in cart ${element.itemId}`);
                else {
                    icon.style.display = 'inline';
                    addToCart(element.itemId);
                }
            }
            else alert("Item is out of Stock");
        })
        div3.append(btn);

        div1.append(image, title, div2, div3);
        container.append(div1);
    });
}

//Function for fetching menu Data
async function fetchMenuData() {
    try {
        const response = await fetch(`http://localhost:8080/restaurants/menus/${menuId}`);

        if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);

        const data = await response.json();
        createItems(data.items);
    } catch (error) {
        console.error("Error:", error);
    }
}
fetchMenuData();

//Function for add to cart*/
async function addToCart(itemId) {
    try {

        const response = await fetch(`http://localhost:8080/addtocarts/${cartId}/${itemId}`, { method: "POST" });

        if (!response.ok)throw new Error(`HTTP error! Status: ${response.status}`);
    } catch (error) {
        console.error("Error:", error);
    }

}

let num = 1;
//function for check in cart is already available in cart or not
async function checkInCart(itemId) {
    try {
        const response = await fetch(`http://localhost:8080/checkInCart/${cartId}/${itemId}`);
        if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
        let result = await response.text();
        console.log("result", result === 'Yes');
        return result === 'Yes';

    } catch (error) {
        console.error("Error:", error);
    }
}
