function bitcoining(arr) {
    let counter = 0;
    let totalMoney = 0;
    let firstDayOfBit = 0;
    let bitcoins = 0

    for (let i = 0; i < arr.length; i++) {
        counter += 1;
        let gold = Number(arr[i]);
        if (counter % 3 == 0) {
            gold = gold * 0.7;
        }
        totalMoney += gold * 67.51;
        if (totalMoney >= 11949.16) {
            if (bitcoins == 0) {
                firstDayOfBit = i + 1;
            }
            while (totalMoney >= 11949.16) {
                totalMoney -= 11949.16;
                bitcoins += 1;
            }
        }
    }
    console.log(`Bought bitcoins: ${bitcoins}`);
    if (bitcoins > 0) {
        console.log(`Day of the first purchased bitcoin: ${firstDayOfBit}`);
    }
    console.log(`Left money: ${totalMoney.toFixed(2)} lv.`);

}
bitcoining([100, 200, 300]);