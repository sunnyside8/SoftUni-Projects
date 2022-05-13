function division(num) {
    let numToPrint = 0;
    if (num % 2 == 0) {
        numToPrint = 2
    }
    if (num % 3 == 0) {
        numToPrint = 3
    }
    if (num % 6 == 0) {
        numToPrint = 6
    }
    if (num % 7 == 0) {
        numToPrint = 7
    }
    if (num % 10 == 0) {
        numToPrint = 10
    }

    if (numToPrint == 0) {
        console.log("Not divisible");
    } else {
        console.log(`The number is divisible by ${numToPrint}`);
    }

}
division(30);