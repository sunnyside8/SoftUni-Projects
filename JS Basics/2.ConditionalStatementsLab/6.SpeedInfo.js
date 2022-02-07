function conditions(input){

    let num = Number(input[0]);

    if(num > 1000){
        console.log('extremely fast')
    }else if( num >= 150 ){
        console.log('ultra fast')
    } else if( num >= 50 ){
        console.log('fast')
    } else if( num >= 10 ){
        console.log('average')
    } else{
        console.log('slow')
    }
}
conditions(["126"]);