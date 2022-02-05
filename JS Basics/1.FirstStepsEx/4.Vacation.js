function read(input){
    let pages = input[0];
    let pagesPerHour = input[1];
    let days = input[2];

    console.log((pages / pagesPerHour) / days)

}
read(["212 ",
"20 ",
"2 "]
)