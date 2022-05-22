function solve(howMany,arr){

    let newArr = arr.splice(0,howMany);
    newArr.reverse();
    console.log(newArr.join(" "));

}
solve(3, [10, 20, 30, 40, 50]);