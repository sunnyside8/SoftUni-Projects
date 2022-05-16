function digit(word){
let out = '';
    switch(word){
        case'one': out = 1; break;
        case'two': out = 2; break;
        case'three': out = 3; break;
        case'four': out = 4; break;
        case'five': out = 5; break;
        case'six': out = 6; break;
        case'seven': out = 7; break;
        case'eight': out = 8; break;
        case'nine': out = 9; break;
        case'zero': out = 0; break;
    }
console.log(out);
}
digit('nine')