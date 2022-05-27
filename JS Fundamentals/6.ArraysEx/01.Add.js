function solve(arr) {
    let sumOld = 0;
    let sumNew = 0;
    for (let i = 0; i < arr.length; i++) {
        let num = arr[i];
        sumOld+=num;
        if(num % 2 == 0){
            arr[i] = num +i;
        } else{
            arr[i] = num -i;
        }
        sumNew+=arr[i];
    }

    console.log(arr);
    console.log(sumOld);
    console.log(sumNew);

}
solve([5, 15, 23, 56, 35]);