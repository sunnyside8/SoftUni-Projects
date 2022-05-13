function phyramid(base,heigthOfStep){
    // gives only 80% in Judge - will refactor soon :)
    let stone = 0;
    let marble = 0;
    let lapis = 0;

    let counter = 0

    while(base > 2){
        let totalBlocks = (Number(base) * Number(base));
        let stoneBlocks = (base - 2) * (base-2)
        let otherMaterialBlocks = totalBlocks - stoneBlocks;
        stone += stoneBlocks * heigthOfStep;
        counter++
        if(counter % 5 === 0){
            lapis += otherMaterialBlocks * heigthOfStep;
        } else{
            marble +=otherMaterialBlocks * heigthOfStep;
        }
        base-=2
    
    }

    console.log(`Stone required: ${Math.ceil(stone)}`);
    console.log(`Marble required: ${Math.ceil(marble)}`);
    console.log(`Lapis Lazuli required: ${Math.ceil(lapis)}`);
    console.log(`Gold required: ${Math.ceil(base * base)}`);
    console.log(`Final pyramid height: ${Math.floor((counter+1) * heigthOfStep)}`);

}
phyramid(23, 0.5);