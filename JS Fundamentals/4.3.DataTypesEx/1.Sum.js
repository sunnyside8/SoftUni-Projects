function solve(input){

    let sum = 0;
    let numberAsString = input.toString();
    for (const num of numberAsString) {
        sum += Number(num);
    }
    console.log(sum);

}
solve(245678);