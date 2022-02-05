function school(input){
    let pens = input[0] * 5.8
    let markers = input[1] * 7.2
    let cleaner = input[2] * 1.2
    let total = pens + markers + cleaner;
    total = total - (total * (input[3] / 100))
    
    console.log(total)
}
school(["2 ",
"3 ",
"4 ",
"25 "]
);