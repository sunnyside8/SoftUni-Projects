function solve(num) {
    console.log('<div class="chessboard">');
    for (let i = 1; i <= num; i++) {
        console.log(`  <div>`);
        for (let j = 1; j <= num; j++) {
            let string = "";
            if(i % 2 == 1){
                string = j % 2 == 1 ? 'back' : 'white';
            } else{
                string = j % 2 == 1 ? 'white' : 'black';
            }
        
            console.log('    <span class="' + string + '"></span>');
        }
        console.log(`  </div>`);
    }
    console.log(`</div>`);
}
solve(3);