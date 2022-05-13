function logIn(arr){

    let username = arr[0];
    arr.splice(0,1);
    username = reverseString(username);
    for(i = 0;i < 3; i++){
        if(username === arr[i]){
            console.log(`User ${reverseString(username)} logged in.`);
            return;
        } else{
            console.log(`Incorrect password. Try again.`);
        }
    }
    console.log(`User ${reverseString(username)} blocked!`);
    

    function reverseString(str) {
        let splitted = str.split("");
        splitted = splitted.reverse();

        return splitted.join("");
    }
}
logIn(['Acer','login','go','let me in','recA'])