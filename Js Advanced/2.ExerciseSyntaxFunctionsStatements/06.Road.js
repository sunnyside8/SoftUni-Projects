function fruit(speed,area){

    let speedAllowed = 0;
    switch(area){
        case "motorway": speedAllowed = 130;break;
        case "interstate": speedAllowed = 90;break;
        case "city": speedAllowed = 50;break;
        case "residential": speedAllowed = 20;break;
    }

    if(speedAllowed >= speed){
        console.log(`Driving ${speed} km/h in a ${speedAllowed} zone`);
    } else{
        let diffrence  = speed - speedAllowed;
        let violation = "";
        if(diffrence <= 20){
            violation = "speeding"
        } else if (diffrence <= 40){
            violation = "excessive speeding"
        } else{
            violation = "reckless driving"
        }
    
        console.log(`The speed is ${diffrence} km/h faster than the allowed speed of ${speedAllowed} - ${violation}`);
    }
}

fruit(200, 'motorway')