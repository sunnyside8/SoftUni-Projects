function basketball(input){

    let yearFee = Number(input[0])
    let shoes = yearFee * 0.6
    let suit = shoes * 0.8
    let ball = suit * 0.25
    let plus = ball * 0.2

    console.log(yearFee + shoes + suit + ball + plus)
}
basketball(["365 "])