function deposit(input){

    let sum = Number(input[0]);
    let period = Number(input[1]);
    let interest = Number(input[2]);

    let interestForYear = sum * (interest /100)
    let interestForOneMonth = interestForYear /12;

    console.log(sum + (interestForOneMonth * period))
}
deposit(["200 ","3 ","5.7"])