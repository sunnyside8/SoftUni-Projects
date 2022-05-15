function solve(num){

    let result = 0;
    let numA = String(num);

    for(let i = 0;i < numA.length;i++){
        result += Number(numA[i]);
    }
   let res = String(result).replace('9',) == result ? `False` : `True`;
   console.log(`${num} Amazing? ${res} `);
    
}
solve(1233);