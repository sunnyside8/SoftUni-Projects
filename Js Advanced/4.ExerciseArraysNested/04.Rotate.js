function arr(input,rotations){

   for(let i = 0;i < rotations;i++){
       input.unshift(input.pop());
   }
   console.log(input.join(' '));

}


arr(['1', 
'2', 
'3', 
'4'], 
2
)