function num(input){

    let num = Number(input[0]);
    if((100 > num  || num > 200) && num !== 0){
        console.log(`invalid`);
    } 
}
num(["99"]);