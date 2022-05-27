function solve(arr,rotations){

    for (let i = 0; i < rotations; i++) {
        arr.push(arr.shift());
    }

    console.log(arr.join(" "));
}
solve([51, 47, 32, 61, 21], 2);