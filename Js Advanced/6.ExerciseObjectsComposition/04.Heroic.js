function heroes(input){

    let allHeroes = [];

    for (const line of input) {
        let [name,level,items] = line.split(' / ');
        level = Number(level);
        items = items ? items.split(', ') : [];
        allHeroes.push({name,level,items});
    }

    console.log(JSON.stringify(allHeroes));
}


heroes(['Isacc / 25 / Apple, GravityGun',
'Derek / 12 / BarrelVest, DestructionSword',
'Hes / 1 / Desolator, Sentinel, Antara']
);