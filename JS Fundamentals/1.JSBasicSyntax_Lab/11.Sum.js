function task(num){
    let sum = 0
    let start = 1;
    for(i = 0;i < num;i++){
        console.log(start);
        sum+=start;
        start+=2;
    }
    console.log(`Sum: ${sum}`);
}
task(5);