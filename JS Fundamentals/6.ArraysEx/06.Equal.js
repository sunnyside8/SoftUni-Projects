function solve(arr){
    let num = -1;
    for (let i = 0; i < arr.length; i++) {
        let num = arr[i];
        let sumLeft =  0;
        for (let j = 0; j < i; j++) {
            sumLeft +=arr[j];
        }

        let rigthSum = 0;
        for (let k = i+1;  k < arr.length; k++) {
           rigthSum +=arr[k];
        }
        if(sumLeft === rigthSum){
           console.log(i);
           return;
        }
    }


        console.log("no");
    

}
solve([1]);