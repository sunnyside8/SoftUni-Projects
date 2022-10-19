function diagonal(matrix){
     let sumOne = 0
     let sumTwo = 0
     let last = matrix.length-1;
    for(let i = 0;i < matrix.length; i++){
        sumOne+= matrix[i][i];
        sumTwo += matrix[i][matrix.length-1-i];
    }

    console.log(`${sumOne} ${sumTwo}`);

}
diagonal([[20, 40],
    [10, 60]]
   );