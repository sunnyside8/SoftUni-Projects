function leap(year){

    if(year % 4 == 0 && year % 100 !== 0  && year % 400 == 0){
                console.log('yes');
            }
    console.log('no');
}
leap(1984);