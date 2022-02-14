function work(input){

    let time = Number(input[0]);
    let day = input[1];

    if((time >9 && time< 19) &&  day !== 'Sunday'){
        console.log(`open`);
    } else{
        console.log(`closed`);
    }

}
work(["19",
"Friday"])

;