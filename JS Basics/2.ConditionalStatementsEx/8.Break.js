function series(input){

    let name = input[0];
    let epizodeLenght = Number(input[1])
    let breaking = Number(input[2]);

    let lunch = breaking * 0.125;
    let relax = breaking * 0.25;

    let total = epizodeLenght + lunch + relax;

    let diff = Math.abs(breaking - total)

    if(total <= breaking){
        console.log(`You have enough time to watch ${name} and left with ${Math.ceil(diff)} minutes free time.`)
    } else{
        console.log(`You don't have enough time to watch ${name}, you need ${Math.ceil(diff)} more minutes.`)
    }
    

}
series(["Teen Wolf",
"48",
"60"])
