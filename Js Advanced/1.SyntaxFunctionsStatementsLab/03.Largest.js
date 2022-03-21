function largest(a,b,c){

 let large = 0;
    if(a > b){
        if(a > c){
            large = a;
        } else{
            large = c;
        }
    } else if(b > c){
        large = b;
    } else{
        large = c;
    }
console.log(`The largest number is ${large}.`)

}

largest(-3, -5, -22.5);