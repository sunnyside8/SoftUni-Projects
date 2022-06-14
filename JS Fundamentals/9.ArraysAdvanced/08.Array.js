function solve(arr) {
  let array = arr.shift().split(" ");
  for (const line of arr) {
    let lining = line.split(" ");
    let i = 0;
    let command = lining.shift();
    switch (command) {
      case "Add":
        array.push(lining[0]);
        break;
      case "Remove":
        array = array.filter((x) => x != lining[0]);
        break;
      case "RemoveAt":
        array.splice(lining[0], 1);
        break;
      case "Insert":
        array.splice(lining[1], 0, lining[0]);
        break;
    }
  }

  console.log(array.join(" "));
}
solve(["6 12 2 65 6 42", "Add 8", "Remove 12", "RemoveAt 3", "Insert 6 2"]);
