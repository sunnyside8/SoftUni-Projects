function cooking(num, p1, p2, p3, p4, p5) {

    let number = Number(num);
    let arrayOfComands = [p1, p2, p3, p4, p5];

    let chop = function () {
        return number / 2;
    }
    let dice = function () {
        return Math.sqrt(number)
    }
    let spice = function () {
        return number +1
    }
    let bake = function(){
        return number *3;
    }
    let fillet = function(){
        return number*0.8
    }

    for(let i = 0;i < 5;i++){
        let current = arrayOfComands[i];
        switch(current){
            case'chop':
            number = chop(number)
            break;
            case'dice':
            number = dice(number)
            break;
            case'spice':
            number = spice(number)
            break;
            case'bake':
            number = bake(number)
            break;
            case'fillet':
            number = fillet(number)
            break;
        }
        console.log(number);
    }
}

cooking('9', 'dice', 'spice', 'chop', 'bake', 'fillet');