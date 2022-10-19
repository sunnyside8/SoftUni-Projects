function arr(input){

    let resultArr = [];

    input = input.sort((a,b) => a-b);

    while(!input.length == 0){
        resultArr.push(input.shift());
        resultArr.push(input.pop());
    }

   return resultArr;
}

arr([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);