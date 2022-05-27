function solve(arr,sum){

    for (let i = 0; i < arr.length; i++) {
        let num1 = arr[i];
        for (let j = i+1; j < arr.length; j++) {
            let num2 = arr[j];
            if(num1 + num2 == sum){
                console.log(num1 + " " + num2);
            }
        }
    }
}
solve([14, 20, 60, 13, 7, 19, 8],27);