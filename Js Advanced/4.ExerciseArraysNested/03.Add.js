function arr(input){

    let newArray = [];

    for(i = 0;i < input.length;i++){
        let command = input[i];
        if(command == 'add'){
            newArray.push(i+1);
        } else {
            newArray.pop();
        }
    }
if(newArray.length > 0){
    for(each of newArray){
        console.log(each)
    }
} else{
    console.log('Empty');
}
    
}

arr(['add', 
'add', 
'remove', 
'add', 
'add']

);