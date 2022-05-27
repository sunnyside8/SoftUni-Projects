function solve(arr1,arr2){
    arr1.forEach(element => {
        arr2.forEach(el =>{
            if(element === el){
                console.log(element);
            }
        })
    });

}
solve(['Hey', 'hello', 2, 4, 'Peter', 'e'],
['Petar', 10, 'hey', 4, 'hello', '2']
);