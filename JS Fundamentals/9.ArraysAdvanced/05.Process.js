function solve(arr) {
  let douled = arr.filter((x, i) => i % 2 == 1);
  douled = douled.map((x) => x * 2);
  douled.reverse();
  console.log(douled.join(" "));
}
solve([10, 15, 20, 25]);
