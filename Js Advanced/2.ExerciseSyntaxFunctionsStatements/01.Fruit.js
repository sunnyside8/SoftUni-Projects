function demo(fruit, weigth, price) {
  let kilos = weigth / 1000;
  console.log(
    `I need $${(kilos * price).toFixed(2)} to buy ${kilos.toFixed(
      2
    )} kilograms ${fruit}.`
  );
}
demo("orange", 2500, 1.8);
