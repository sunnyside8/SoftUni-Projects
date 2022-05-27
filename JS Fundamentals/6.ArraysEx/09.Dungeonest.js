function solve(line){
    let rooms = line[0].split("|");
    let health = 100;
    let coins = 0;
    
    for (let i = 0; i < rooms.length; i++) {
        let tokens = rooms[i].split(" ");
        let action = tokens[0];
        let number = Number(tokens[1]);
        if(action === 'potion'){
            console.log(`You healed for ${Math.min(number,100 - health)} hp.`);
            health = Math.min(health + number,100);
            console.log(`Current health: ${health} hp.`);
        } else if(action === 'chest'){
            coins +=number;
            console.log(`You found ${number} coins.`);
        } else{
            if(health - number <= 0){
                console.log(`You died! Killed by ${action}.` );
                console.log(`Best room: ${i+1}`);
                return;
            } 
            health -= number;
            console.log(`You slayed ${action}.`);
        }
    }

    console.log("You've made it!");
    console.log(`Coins: ${coins}`);
    console.log(`Health: ${health}`);


}
solve(["cat 10|potion 30|orc 10|chest 10|snake 25|chest 110"]);