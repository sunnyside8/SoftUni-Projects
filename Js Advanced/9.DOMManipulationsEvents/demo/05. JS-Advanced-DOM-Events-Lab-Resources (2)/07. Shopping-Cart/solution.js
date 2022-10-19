function solve() {
   let addButtons = Array.from(document.getElementsByClassName('add-product'));
   let textArea = document.querySelector('textarea');
   let checkoutButton = document.getElementsByClassName('checkout')[0];

   let list = {};

   for (const button of addButtons) {
      button.addEventListener('click', addToCart)
   }

   checkoutButton.addEventListener('click', checkout)

   function addToCart(ev) {
      let productDiv = ev.currentTarget.parentElement.parentElement;
      let productName = productDiv.getElementsByClassName('product-title')[0].textContent;
      let productPrice = Number(productDiv.getElementsByClassName('product-line-price')[0].textContent);
      textArea.textContent += `Added ${productName} for ${productPrice.toFixed(2)} to the cart.\n`;

      let count = 0;
      if (list[productName] === undefined) {
         count = 1
      } else {
         let result = list[productName].count;
         count = Number(result) + 1;
      }
      list[productName] = { price: productPrice, count: count };
   }

   function checkout() {
      for (const button of addButtons) {
         button.disabled = true
      }
      checkoutButton.disabled = true;

      let keyset = Object.keys(list);
      let productNames = keyset.join(', ');
      let price = 0;
      for (const key of keyset) {
         let contance = list[key];
         price += Number(contance.price) * Number(contance.count);
      }
      textArea.textContent += `"You bought ${productNames} for ${price.toFixed(2)}."`

   }
}