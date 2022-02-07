function conditions(input){

    let figure = input[0];
    let area = 0;
    let side = Number(input[1])

    if(figure === 'square'){
        area = side * side
    }else if( figure === 'rectangle' ){
        let sideTwo = Number(input[2])
        area = side * sideTwo
    } else if(figure === 'circle'){
        area = Math.PI * (side* side);
    } else if( figure === 'triangle' ){
        let sideTwo = Number(input[2])
        area = (side * sideTwo) /2;
    } 

    console.log((area).toFixed(3))
}
conditions(["circle",
"6"])
;