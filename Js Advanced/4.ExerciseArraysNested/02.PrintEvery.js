function arr(input,num){

    let newArr = [];

    for(let i = 0;i< input.length;i+=Number(num)){
        newArr.push(input[i]);
    }
    
    return newArr;
}

console.log(arr(	['dsa',
'asd', 
'test', 
'tset'], 
2


));