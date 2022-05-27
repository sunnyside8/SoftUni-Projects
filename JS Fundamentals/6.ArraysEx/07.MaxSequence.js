function solve(arr){

    let newArray = [];
    let firstArray = [];

    for (let i = 0; i < arr.length; i++) {
        firstArray = [];
        for (let j = i; j < arr.length; j++) {
            if(arr[i] === arr[j]){
                firstArray.push(arr[j]);
            } else{
                break;
            }
            if(firstArray.length > newArray.length){
                newArray = firstArray;
            }
        }
    }
    console.log(newArray.join(" "));


}
solve([0, 1, 1, 5, 2, 2, 6, 3, 3]);