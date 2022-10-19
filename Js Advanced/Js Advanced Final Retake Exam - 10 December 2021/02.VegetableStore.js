class VegetableStore {

  constructor(owner, location) {
    this.owner = owner;
    this.location = location;
    this.availableProducts = [];
  }

  loadingVegetables(vegetables) {
    let names = new Set();

    for (const line of vegetables) {
      let [type, quantity, price] = line.split(' ');

      if (this.availableProducts.some(x => x.type == type)) {
        let product = this.availableProducts.find(x => x.type == type);
        product.quantity = Number(quantity) + Number(product.quantity);

        if (product.price < price) {
          product.price = price;
        }
      } else {
        this.availableProducts.push({ type, quantity, price });
      }

      names.add(type);
    }

    return `Successfully added ` + Array.from(names).join(', ');
  }

  buyingVegetables(selectedProducts) {

    let totalPrice = 0;
    for (const line of selectedProducts) {
      let [type, quantity] = line.split(' ');

      if (!this.availableProducts.some(x => x.type == type)) {
        throw new Error(`${type} is not available in the store, your current bill is $${Number(totalPrice).toFixed(2)}.`)
      }

      let product = this.availableProducts.find(x => x.type == type);

      if (Number(product.quantity) < Number(quantity)) {
        throw new Error(`The quantity ${quantity} for the vegetable ${type} is not available in the store, your current bill is $${Number(totalPrice).toFixed(2)}.`)
      }

      totalPrice += Number(quantity) * Number(product.price);
      product.quantity -= Number(quantity);
    }
    return `Great choice! You must pay the following amount $${totalPrice.toFixed(2)}.`
  }

  rottingVegetable(type, quantity) {
    if (!this.availableProducts.some(x => x.type == type)) {
      throw new Error(`${type} is not available in the store.`)
    }

    let product = this.availableProducts.find(x => x.type == type);

    if (product.quantity <= quantity) {
      // let indexOfVeg = this.availableProducts.findIndex(x => x.type == type);
      // this.availableProducts.splice(indexOfVeg, 1);
      product.quantity = 0
      return `The entire quantity of the ${type} has been removed.`

    } else {
      product.quantity -= quantity;
      return `Some quantity of the ${type} has been removed.`;
    }
  }

  revision() {
    let strings = [];
    strings.push(`Available vegetables:`);
    this.availableProducts.sort((a, b) => Number(a.price) - Number(b.price))
      .forEach(x => strings.push(`${x.type}-${Number(x.quantity)}-$${x.price}`));
    strings.push(`The owner of the store is ${this.owner}, and the location is ${this.location}.`);
    return strings.join('\n');
  }
}

let vegStore = new VegetableStore('Jerrie Munro', '1463 Pette Kyosheta, Sofia');

console.log(vegStore.loadingVegetables(["Okra 2.5 3.5", "Beans 10 2.8", "Celery 5.5 2.2", "Celery 0.5 2.5"]));

console.log(vegStore.rottingVegetable("Okra", 1));
console.log(vegStore.rottingVegetable("Okra", 2.5));

console.log(vegStore.buyingVegetables(["Beans 8", "Celery 1.5"]));

console.log(vegStore.revision());

