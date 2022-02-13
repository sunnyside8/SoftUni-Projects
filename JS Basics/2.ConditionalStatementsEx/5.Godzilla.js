function movie(input){

    let budget = Number(input[0]);
    let stats = Number(input[1]);
    let pricePerClothing = Number(input[2]);

    let decoration = budget * 0.1;

    let clothing = stats * pricePerClothing;
    if(stats > 150){
        clothing = clothing * 0.9
    }
    let totalSum = decoration + clothing;
    let diff = Math.abs(budget - totalSum);

    if(budget >= totalSum ){
        console.log(`Action!`)
        console.log(`Wingard starts filming with ${(diff).toFixed(2)} leva left.`)
    } else{
        console.log(`Not enough money!`)
        console.log(`Wingard needs ${(diff).toFixed(2)} leva more.`)
    }
};
movie(["9587.88",
"222",
"55.68"]);