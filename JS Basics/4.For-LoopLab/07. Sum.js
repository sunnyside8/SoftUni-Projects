function sum(input){

    let text = input[0];

    let sum =0;

    for (let index = 0; index < text.length; index++) {
        let number = text[index];

        sum += Number(number)
        
    }

    console.log(`The sum of the digits is:${sum}`);
}
sum(["1234"])