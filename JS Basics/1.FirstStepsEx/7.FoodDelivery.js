function food(input){
 
    let chiken = Number(input[0]) * 10.35
    let fish = Number(input[1]) * 12.4
    let vegan = Number(input[2]) * 8.15

    let sum = chiken + fish + vegan
    let dessert = sum * 0.2;
    console.log(sum + dessert + 2.5)
}
food(["2 ",
"4 ",
"3 "]
)