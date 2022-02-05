function concatenate(input){
    let  name = input[0];
    let lastName = input[1];
    let age = input[2];
    let town = input[3];

    console.log(`You are ${name} ${lastName}, a ${age}-years old person from ${town}.`)
};
concatenate(['Sunny','Slava',26,'Sliven']);