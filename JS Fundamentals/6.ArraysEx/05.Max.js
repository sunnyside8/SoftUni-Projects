function solve(arr){
    let flag = true;
    let numbers = [];
    for (let i = 0; i < arr.length; i++) {
        let num = arr[i];
        for (let j = i+1; j < arr.length; j++) {
            if(num <= arr[j]){
                flag = false;
                break;
            }
        }
        if(flag){
            numbers.push(num);
        }
        flag = true;

    }

    console.log(numbers.join(" "));
}
solve([41, 41, 34, 20]);