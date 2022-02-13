function time(input){

    let hours = Number(input[0]);
    let minutes = Number(input[1]);

    let allMinutes = hours * 60 + minutes + 15;

    hours = Math.floor(allMinutes / 60);
    minutes = allMinutes % 60;
    
    if(hours > 23){
        hours = 0
    }
    if(minutes < 10){
        console.log(`${hours}:0${minutes}`);
    } else{
        console.log(`${hours}:${minutes}`);
    }
};
time(["23", "59"]);