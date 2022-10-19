function town(input){

    let towns ={};

    for (const info of input) {
        let [town,populationText] = info.split(' <-> ');
        let population = Number(populationText);

        if(!towns[town]){
            towns[town] = 0
        }

        towns[town] += population;
    }
    

    for (const town in towns) {
       console.log(`${town} : ${towns[town]}`) 
    }

}
town(['Sofia <-> 1200000',
'Montana <-> 20000',
'New York <-> 10000000',
'Washington <-> 2345000',
'Las Vegas <-> 1000000']
)