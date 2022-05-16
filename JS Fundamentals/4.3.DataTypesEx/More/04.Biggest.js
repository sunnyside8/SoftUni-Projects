
function solve(...args){
    args.sort((a,b) => a - b);
    console.log(args[args.length-1]);
}
solve(-2,
    7,
    3
    );