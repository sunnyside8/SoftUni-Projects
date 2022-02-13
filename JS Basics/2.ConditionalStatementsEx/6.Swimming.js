function swimming(input){
    
    let record = Number(input[0]);
    let meters = Number(input[1]);
    let timePerSec = Number(input[2]);

    let plus = Math.trunc(meters/15)

    let totalTime = meters * timePerSec + plus * 12.5;

    if(record >totalTime){
        console.log(`Yes, he succeeded! The new world record is ${totalTime.toFixed(2)} seconds.`)
    } else{
        console.log(`No, he failed! He was ${(totalTime - record).toFixed(2)} seconds slower.`)
    }

}
swimming(["55555.67",
"3017",
"5.03"])

