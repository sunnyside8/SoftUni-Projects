function solve(num1,mark,num2){
    let sum = 0;
    switch(mark){
        case '+' : sum = Number(num1) + Number(num2);break; 
        case '-' : sum = Number(num1) - Number(num2);break;
        case '*' : sum = Number(num1) * Number(num2);break;
        case '/' : sum = Number(num1) / Number(num2);break;
    }
    console.log(sum.toFixed(2));
}
solve(25.5,
    '-',
    3
    
    );