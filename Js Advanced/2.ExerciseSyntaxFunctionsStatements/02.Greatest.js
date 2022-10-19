function greatest(a,b){

    while(a !== b){
        if(a > b){
            a-= b
        } else{
            b-=a
        }
    }
    console.log(a);
}
greatest(20, 28);