function age(age){
    let string = "";
    if(age < 0){
        string = "out of bounds"
    }else if( age< 3){
        string = "baby"
    } else if(age < 14){
        string = "child"
    }else if(age < 20){
        string= "teenager";
    } else if(age < 65){
        string = "adult"
    } else if ( age >= 66){
        string = "elder";
    } 
    console.log(string);
}
age(-1);