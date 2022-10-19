function colorize() {
      let rowElements = document.getElementsByTagName('tr');
    
    let rows = Array.from(rowElements);

   rows.forEach((x,i) => {
       if(i % 2 != 0 ){
            x.style.backgroundColor = 'teal';
       }
   });
}