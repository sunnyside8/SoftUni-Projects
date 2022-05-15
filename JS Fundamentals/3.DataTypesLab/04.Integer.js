function solve(...nums) {
    let sum = nums.reduce(
        function (a, b) {
            return a + b
        }, 0);
    let type = 'Integer';
    if (Math.round(sum) !== sum) {
        type = 'Float';
    }

    console.log(`${sum} - ${type}`);

}
solve(100, 200, 303);