function equal(matrix){

    let count = 0;
    for(i = 1;i < matrix.length-1;i++){
        for(j = 0;j < matrix[i].length-1;j++){
           let element  = matrix[i][j];     
           let elementAbove = matrix[i-1][j]
           let elementBellow = matrix[i+1][j]
           if(element === elementAbove || element === elementBellow){
                count+=1;
           }
        }
    }

    console.log(count);
}
equal([ ['2', '3', '4', '7', '0'],
        ['4', '0', '5', '3', '4'],
        ['2', '3', '5', '4', '2'],
        ['9', '8', '7', '5', '4']]
)


equal([['test', 'yes', 'yo', 'ho'],
       ['well', 'done', 'yo', '6'],
       ['not', 'done', 'yet', '5']])
