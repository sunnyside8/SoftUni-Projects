function solve(array) {
  let oddPositionNumbers = array.filter((element, index) => {
    if (index % 2 != 0) {
      return Number(element);
    }
  });

  return oddPositionNumbers
    .map((x) => x * 2)
    .reverse()
    .join(" ");
}

//console.log(solve([10, 15, 20, 25]));
console.log(solve([3, 0, 10, 4, 7, 3]));
