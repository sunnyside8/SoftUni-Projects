function town(input){

    let names = input[0].split(' | ');
    let columnOne = names[0].slice(2);
    let columnTwo = names[1];
    let columnThree = names[2].slice(0,-2);

    let result = []
    for(i = 1;i< input.length;i++){
        input[i] = input[i].substring(2,input[i].length-2);
        let [one,two,three] = input[i].split(' | ');
        two = Number(two).toFixed(2);
        three = Number(three).toFixed(2);
        result.push({
            [columnOne]: one,
            [columnTwo]:Number(two),
            [columnThree]:Number(three),
        });
    }

    console.log(JSON.stringify(result));

}
town(['| Town | Latitude | Longitude |',
'| Sofia | 42.696552 | 23.32601 |',
'| Beijing | 39.913818 | 116.363625 |']
);