function stars(count){

    if(count == 1){
        console.log("*");
        return;
    }
   for(let i = 0;i < count;i++){
            console.log('* '.repeat(count));
        
    } 
}

stars(2);