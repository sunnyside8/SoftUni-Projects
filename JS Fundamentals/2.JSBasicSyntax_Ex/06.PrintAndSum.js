function print(m, n) {
    let arr = []
    let sum = 0;
    for (let i = m; i <= n; i++) {
        sum += i;
        arr.push(i);
    }
    console.log(arr.join(" "));
    console.log(`Sum: ${sum}`);
}
print(5, 10)