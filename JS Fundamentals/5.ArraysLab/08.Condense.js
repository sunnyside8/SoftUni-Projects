function solve(arr){

    while(arr.length > 1){
    let condesec = [];
    for(let  i= 0;i < arr.length -1 ; i++){
        condesec[i] = arr[i] + arr[i+1];
    }
    arr = condesec;
}

console.log(arr[0]);

}
solve([5,0,4,1,2]);