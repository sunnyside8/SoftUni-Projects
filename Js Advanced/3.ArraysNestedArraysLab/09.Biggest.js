function biggest(matix){

   let allArays = [];
    for(i = 0;i < matix.length;i++){
        allArays = allArays.concat(matix[i])
    }
   allArays.sort((a,b) => a -b);
   console.log(allArays[allArays.length-1]);

}
biggest([[3, 5, 7, 12],
    [-1, 4, 33, 2],
    [8, 3, 0, 4]]
   
   )