function search() {
  
   let searchElememnt = document.getElementById('searchText');
   let allLiElememnts = Array.from(document.querySelectorAll('#towns li'));

   let searchText = searchElememnt.value;

   allLiElememnts.forEach(el => {
      el.style.fontWeight= 'none';
      el.style.textDecoration = 'none';
   });

   let targetLis = allLiElememnts
   .filter(x => x.textContent.includes(searchText))
   .map(x => {
      x.style.fontWeight= 'bold';
      x.style.textDecoration = 'underline';
   });

   let result = document.getElementById('result');
   result.textContent = `${target.length} matches found`;
   
}
