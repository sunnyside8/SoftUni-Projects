function painting(input){
    let plastic = (Number(input[0]) + 2) * 1.5
    let paint = (Number(input[1]) * 1.1) * 14.5
    let paintTwo = Number(input[2]) * 5
    let sum = plastic + paint + paintTwo + 0.4
    let worker = (sum * 0.3) * Number(input[3]);
    
    console.log(sum + worker)

};
painting(["10 ",
"11 ",
"4 ",
"8 "]
)