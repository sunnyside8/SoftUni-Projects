function search() {
   let listElements = document.querySelectorAll('ul#towns li');
   let resultElement = document.getElementById('result');

   let searchText = document.getElementById('searchText').value;
   let matches = 0;

   for (const element of listElements) {
      element.style.fontWeight = 'normal';
      element.style.textDecoration = '';
   }

   for (const element of listElements) {
      let text = element.textContent;

      if (text.match(searchText)) {
         matches++;
         element.style.fontWeight = 'bold';
         element.style.textDecoration = 'underline';
      }
   }

   resultElement.textContent = `${matches} found.`
}
