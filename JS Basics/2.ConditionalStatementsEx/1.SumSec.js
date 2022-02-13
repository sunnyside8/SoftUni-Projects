function calculate(input){

        let first = Number(input[0]);
        let second = Number(input[1]);
        let third = Number(input[2]);

        let total = first + second + third
        let mins = Math.floor(total / 60)
        let sec = total % 60;

        if(sec > 9){
        console.log(`${mins}:${sec}`)
        } else{
            console.log(`${mins}:0${sec}`) 
        }


}
calculate(["50",
"50",
"49"])

;