function upper(input){
    const result = input.split(/[,\s!?]+/);
    let newArray = [];
   for(i = 0;i < result.length;i++){
       let word = result[i].toUpperCase();
       newArray[i] = word.trim();
   }

   console.log(newArray.join(', '));
}
upper('FUNCTIONS, IN, JS, CAN, BE, NESTED, I, E, HOLD, OTHER, FUNCTIONS')