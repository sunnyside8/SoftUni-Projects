class Restaurant {

  constructor(budgetMoney) {
    this.budgetMoney = budgetMoney;
    this.menu = {};
    this.stockProducts = {};
    this.history = [];
  }

  loadProducts(array) {
    let strings = [];

    for (const line of array) {
      let [productName, productQuantity, productTotalPrice] = line.split(' ');
      if (productTotalPrice > this.budgetMoney) {
        strings.push(`There was not enough money to load ${productQuantity} ${productName}`)
      } else {
        this.budgetMoney = Number(this.budgetMoney) - Number(productTotalPrice);
        strings.push(`Successfully loaded ${productQuantity} ${productName}`);
        if (this.stockProducts[productName]) {
          this.stockProducts[productName] = Number(this.stockProducts[productName]) + productQuantity;
        } else {
          this.stockProducts[productName] = productQuantity;
        }
      }
    }

    return strings.join('\n');
  }

  addToMenu(meal, arrayProducts, price) {

    if (this.menu[meal]) {
      return `The ${meal} is already in the our menu, try something different.`
    }
    this.menu[meal] = { arrayProducts, price };

    if (Object.keys(this.menu).length == 1) {
      return `Great idea! Now with the ${meal} we have 1 meal in the menu, other ideas?`
    } else {
      return `Great idea! Now with the ${meal} we have ${Object.keys(this.menu).length} meals in the menu, other ideas?`
    }
  }

  showTheMenu() {
    let lines = [];
    if (Object.keys(this.menu).length == 0) {
      return "Our menu is not ready yet, please come later...";
    } else {
      for (const key of Object.keys(this.menu)) {
        lines.push(`${key} - $ ${this.menu[key].price}`);
      }
    }

    return lines.join('\n');
  }

  makeTheOrder(meal) {
    if (!this.menu[meal]) {
      return `There is not ${meal} yet in our menu, do you want to order something else?`
    }

    let products = this.menu[meal].arrayProducts;

    for (const line of products) {
      let prod = line.split(' ')[0];
      if (!this.stockProducts[prod]) {
        return `For the time being, we cannot complete your order (${meal}), we are very sorry...`
      }
    }

    for (const line of products) {
      let [prod, stock] = line.split(' ');
      if (Number(this.stockProducts[prod]) - Number(stock) < 0) {
        return `For the time being, we cannot complete your order (${meal}), we are very sorry...`;
      }
      this.stockProducts[prod] = Number(this.stockProducts[prod]) - Number(stock);
    }

    this.budgetMoney += this.menu[meal].price;

    return `Your order (${meal}) will be completed in the next 30 minutes and will cost you ${this.menu[meal].price}.`
  }
}

let kitchen = new Restaurant(1000);

kitchen.loadProducts(['Yogurt 30 3', 'Honey 50 4', 'Strawberries 20 10', 'Banana 5 1']);

kitchen.addToMenu('frozenYogurt', ['Yogurt 1', 'Honey 1', 'Banana 1', 'Strawberries 10'], 9.99);

console.log(kitchen.makeTheOrder('frozenYogurt')); 