function solve(arr){
    let sumEv = 0;
    let sumOdd = 0;

    arr.forEach(element => {
        element = Number(element);
        if(element % 2 == 0){
            sumEv+=element
        } else{
            sumOdd += element; 
        }
    });

    console.log(sumEv  - sumOdd);
}
solve([1,2,3,4,5,6]);