function solve(yield){

    let days = 0;
    let totalYield = 0;
    while(yield >= 100){
        totalYield += yield;
        yield -= 10;
        days++;
        if(totalYield - 26 < 0){
            totalYield =  0;
        } else{
            totalYield -= 26;
        }
    }

    console.log(days);
    console.log(Math.max(totalYield - 26,0));
}
solve(111);