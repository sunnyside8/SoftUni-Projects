function solve(uncompleteString,piece,string){
    uncompleteString = uncompleteString.replace('_',piece);
    if(uncompleteString == string){
        console.log(`Matched`);
    } else{
        console.log(`Not Matched`);
    }
}
solve('Str_ng', 'i', 'String');