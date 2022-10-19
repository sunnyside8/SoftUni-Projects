function bigger(input){

    input = input.sort((a,b) => a - b);
   
    let newLength = Math.floor(input.length/2);
    let bigger = input.splice(newLength);

    return bigger;

}
bigger([4, 7, 2, 5])
bigger([3, 19, 14, 7, 2, 19, 6])