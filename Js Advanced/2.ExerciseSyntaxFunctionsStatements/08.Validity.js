function validity(x1,x2,y1,y2){

   console.log(Number.isInteger(result(x1,y1))
                ? console.log(`{${x1},${y1}} to {0, 0} is valid`)
                : console.log(`{${x1},${y1}} to {0, 0} is invalid`));
    
    console.log(Number.isInteger(result(x2,y2))
                ? console.log(`{${x2},${y2}} to {0, 0} is valid`)
                : console.log(`{${x2},${y2}} to {0, 0} is invalid`));            

                console.log(Number.isInteger(result(x1-x2,y1-y2))
                ? console.log(`{${x1},${y1}} to {${x2} ${y2}} is valid`)
                : console.log(`{${y1},${y2}} to {${x2} ${y2}} is invalid`)); 

                
    function result(x, y) {
        return Math.sqrt(x ** 2 + y ** 2);
    }
}

validity(2, 1, 1, 1);