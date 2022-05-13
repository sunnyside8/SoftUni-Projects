function sort(...numbs){
    numbs.sort((a,b) => b-a)
    console.log(numbs.join("\n"));
}
sort(2,1,3);