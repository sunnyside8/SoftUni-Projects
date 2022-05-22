function solve(dayAsNumber){

    let days = [
        'Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday'
    ];

    let index = dayAsNumber -1;
    console.log(days[index] == undefined ? "Invalid day!" : days[index]);
}
solve(11);