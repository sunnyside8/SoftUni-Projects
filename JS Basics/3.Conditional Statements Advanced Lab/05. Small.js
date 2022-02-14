function shop(input){

    let product = input[0];
    let city = input[1];
    let quantity = Number(input[2]);

    let price = 0;

    if(city === 'Sofia'){

        switch(product){
            case'coffee':price = 0.5;break;
            case 'water':price = 0.8;break;
            case 'beer':price = 1.2;break;
            case'sweets':price = 1.45;break;
            case'peanuts':price = 1.6;break;
        }
    } else if(city === 'Plovdiv'){
        switch(product){
            case'coffee':price = 0.4;break;
            case 'water':price = 0.7;break;
            case 'beer':price = 1.15;break;
            case'sweets':price = 1.30;break;
            case'peanuts':price = 1.5;break;
        }

    } else if (city === 'Varna'){
        switch(product){
            case'coffee':price = 0.45;break;
            case 'water':price = 0.7;break;
            case 'beer':price = 1.10;break;
            case'sweets':price = 1.35;break;
            case'peanuts':price = 1.55;break;
        }

    }
    console.log(quantity*price);
}
shop(["coffee",
"Varna",
"2"])
;