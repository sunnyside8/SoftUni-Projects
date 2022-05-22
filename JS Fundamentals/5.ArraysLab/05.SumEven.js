function solve(arr){
    let sum = 0;

    arr.forEach(element => {
        element = Number(element);
        if(element % 2 == 0){
            sum+=element
        }
    });

    console.log(sum);
}
solve(['1','2','3','4','5','6']);