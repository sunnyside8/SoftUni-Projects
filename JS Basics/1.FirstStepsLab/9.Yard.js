function yard(input){
 
    let sum = input[0] * 7.61;
    let disscount = sum * 0.18;
    let finalSum = sum - disscount;

    console.log(`The final price is: ${finalSum} lv.`)
    console.log(`The discount is: ${disscount} lv.`)
};
yard(["550"]);