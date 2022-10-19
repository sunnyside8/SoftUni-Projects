function pie(pies,startPie,endPie){

    const startIndex = pies.indexOf(startPie);
    const endIndex = pies.indexOf(endPie);

    const piesWeNeed = pies.slice(startIndex,endIndex+1);

    return piesWeNeed;


}
console.log(pie(['Pumpkin Pie',
'Key Lime Pie',
'Cherry Pie',
'Lemon Meringue Pie',
'Sugar Cream Pie'],
'Key Lime Pie',
'Lemon Meringue Pie'))
