function create(words) {
   let contentEl = document.getElementById('content');

   for (const word of words) {
      let newDiv = document.createElement('div');
      let newPar = document.createElement('p');
      newPar.textContent = word;
      newPar.style.display = 'none';
      newDiv.appendChild(newPar);
      newDiv.addEventListener('click', function () {
         newDiv.childNodes[0].style.display = 'inline';
      })
      contentEl.appendChild(newDiv);
   }
}