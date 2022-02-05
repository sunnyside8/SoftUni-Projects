function tank(input){
    let sideOne = Number(input[0])
    let sideTwo = Number(input[1])
    let sideThree = Number(input[2])
    let volume = (sideOne * sideTwo * sideThree) / 1000
    volume = volume - (volume * (Number(input[3]) / 100))
    console.log(volume)
}
tank(["85 ",
"75 ",
"47 ",
"17 "]
)