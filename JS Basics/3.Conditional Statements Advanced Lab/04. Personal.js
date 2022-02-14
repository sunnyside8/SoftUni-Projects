function gender(input){

    let age =Number(input[0]);
    let gender = input[1];
    let string = "";

    if(gender == 'f'){
        if(age <16){
           string = 'Miss';
        } else{
           string = 'Ms.';
        }
    } else{
        if(age < 16){
            string = 'Master';
        } else{
            string = 'Mr.'
        }
    }

    console.log(string)

}
gender(["12",
"f"])
;