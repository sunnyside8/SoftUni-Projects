function shop(input){

    let fruit = input[0];
    let day = input[1];
    let quantity = Number(input[2]);
    let price = 0;

    if(day === 'Monday'  || day === 'Tuesday' || day === 'Wednesday' || day === 'Thursday' || day === 'Friday'){
        switch (fruit){
            case'banana':price = 2.5;break;
            case'apple':price = 1.2;break;
            case'orange':price = 0.85;break;
            case'grapefruit':price = 1.45;break;
            case'kiwi':price = 2.7;break;
            case'pineapple':price =5.5;break;
            case'grapes':price =3.85;break;
            
        }
        if(price == 0){
            console.log(`error`);
        } else{
            console.log((quantity * price).toFixed(2))
        }
    } else if (day === 'Saturday' || day === 'Sunday'){
        switch (fruit){
            case'banana':price = 2.7;break;
            case'apple':price = 1.25;break;
            case'orange':price = 0.9;break;
            case'grapefruit':price = 1.60;break;
            case'kiwi':price = 3;break;
            case'pineapple':price =5.6;break;
            case'grapes':price =4.2;break;
        }
        if(price == 0){
            console.log(`error`);
        } else{
            console.log((quantity * price).toFixed(2))
        }
    } else{
        console.log(`error`);
    }
}
shop(["tomato",
"Monday",
"0.5"])

