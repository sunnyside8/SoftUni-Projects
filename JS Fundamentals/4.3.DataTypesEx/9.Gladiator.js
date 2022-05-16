function solve(lostFigths,helmetPrice,swordPrice,shieldPrice,armourPrice){
    let sum = 0 ;

    for(let count = 1;count <= lostFigths;count++){
        
        if(count % 2 === 0){
            sum+=helmetPrice;
        };
        if(count % 3 === 0){
            sum+=swordPrice
        };

        if(count % 6 === 0){
            sum+=shieldPrice
        }

        if(count % 12 === 0){
            sum+=armourPrice
        }

    }


    console.log(`Gladiator expenses: ${sum.toFixed(2)} aureus`);

}
solve(23,
    12.50,
    21.50,
    40,
    200
    
    );