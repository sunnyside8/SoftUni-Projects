function aggregateElements(elements) {

    aggregate(elements, 0, (a, b) => a + b);
    
    aggregate(elements, 0, (a, b) => a + 1 / b);
    
    aggregate(elements, '', (a, b) => a + b);
    
    function aggregate(array,startValue,functionin){
        let start = startValue;
        for(i = 0;i<array.length;i++){
           start = functionin(start,array[i])
        }
        console.log(start);
    }
    
    }
    aggregateElements([1, 2, 3])