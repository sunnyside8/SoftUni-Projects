function arr(matrix){


    let sum = matrix[0].reduce((a,b) => a+b);

    for(let i = 0;i<matrix[0].length;i++){

        let currentCol = 0;

        for(let j = 0;j<matrix.length;j++){
            currentCol+=matrix[j][i];
        }

        if(currentCol !== sum){
            return false;
        }
    }

    return true;

}
console.log(arr([[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]]
   ));