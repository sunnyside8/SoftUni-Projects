function toyShop(input){

    let excursionPrice = Number(input[0]);
    let puzzleCout = Number(input[1]);
    let talkingDog = Number(input[2]);
    let teddyBears = Number(input[3]);
    let minions = Number(input[4]);
    let trucks = Number(input[5]);

    let toyCount = puzzleCout + talkingDog + teddyBears + minions + trucks;

    let money = puzzleCout * 2.6 + talkingDog * 3 + teddyBears * 4.1 + 
    minions * 8.2 + trucks * 2;

    if(toyCount >= 50){
        money = money * 0.75
    }

    money = money * 0.9;

    if(money >= excursionPrice){
        console.log(`Yes! ${(money - excursionPrice).toFixed(2)} lv left.`)
    } else{
        console.log(`Not enough money! ${(excursionPrice - money).toFixed(2)} lv needed.`)
    }

}
toyShop(["320",
"8",
"2",
"5",
"5",
"1"])

;