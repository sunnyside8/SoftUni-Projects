function round(number,persision){

    number = Number(number);
    persision = Number(persision);

    if(persision > 15){
        persision = 15
    }

    number = number.toFixed(persision);
    console.log(parseFloat(number));

}
round(3.1415926535897932384626433832795,2);