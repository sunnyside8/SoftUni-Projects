function objDemo(input){

    let obj = {};

    for(i = 0;i < input.length;i+=2){
        let productName = input[i];
        let calories = Number(input[i+1]);
        obj[productName] = calories;

    }
    console.log(obj);



}
objDemo(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']);