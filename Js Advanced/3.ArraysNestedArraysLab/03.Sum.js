function first(strings){

    const first = Number(strings.shift());
    const last = Number(strings.pop());

    return first + last;
    
}
first(['20', '30', '40']);