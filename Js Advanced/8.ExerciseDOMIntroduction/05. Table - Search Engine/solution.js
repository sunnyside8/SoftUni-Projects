function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      let searechElememnt = document.getElementById('searchField');
      let rowElememnts = Array.from(document.querySelectorAll('tbody tr'));


      let searchText =searechElememnt.value;
      rowElememnts.forEach(el => {
         el.className = '';
      });

      let filterRows = rowElememnts.filter(el =>{
         let values = Array.from(el.children);
        if(values.some(x => x.textContent.includes(searchText))){
            el.className = 'select';

        }
      })

      searechElememnt.value = '';

   }
}