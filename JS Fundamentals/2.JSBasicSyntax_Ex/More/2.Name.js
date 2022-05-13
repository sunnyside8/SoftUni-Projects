function eng(num) {
    num = String(num)
    let lastDigit =Number(num.split('').pop());
    let str = "";
    switch(lastDigit){
        case 1:str = "one";break;
        case 2:str = "two";break;
        case 3:str = "three";break;
        case 4:str = "four";break;
        case 5:str = "five";break;
        case 6:str = "six";break;
        case 7:str = "seven";break;
        case 8:str = "eigth";break;
        case 9:str = "nine";break;
        case 0:str = "zero";break;
    }
    console.log(str);
}
eng(512);