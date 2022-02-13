function shopping(input){

    let budget = Number(input[0]);
    let video = Number(input[1]);
    let prossesors = Number(input[2]);
    let ram = Number(input[3]);

    let totalVideo = video * 250;
    let totalProssesors = (totalVideo * 0.35)*prossesors;
    let totalRam = (totalVideo * 0.1) * ram;

    let total = totalVideo + totalProssesors + totalRam;

    if(video > prossesors){
        total = total * 0.85
    }

    let diff = Math.abs(total-budget)
    if(budget >= total){
        console.log(`You have ${diff.toFixed(2)} leva left!`)
    } else{
        console.log(`Not enough money! You need ${diff.toFixed(2)} leva more!`)
    }
}
shopping(["920.45",
"3",
"1",
"1"])
