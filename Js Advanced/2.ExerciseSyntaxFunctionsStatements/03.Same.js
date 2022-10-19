function same(num){

    let input = num.toString();
    let isSame = true;
    let sum = 0;
    let digitToCompare = input[0];

    for(let i = 0;i < input.length;i++){
        sum += Number(input[i])
        if(digitToCompare !== input[i]){
            isSame = false
        }
    }
    console.log(isSame);
    console.log(sum);
}

same(1234);