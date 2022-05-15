function solve(num){
    num = String(num);

    for(let i = 0;i < num;i++){
        for(let j = 0;j < num;j++){
            for(let k = 0;k < num;k++){
                console.log(String.fromCharCode(97 +i) + String.fromCharCode(97 + j) + String.fromCharCode(97 + k) );
            }
        } 
    }

}
solve('3');