function solve() {
  
  let inputElement = document.getElementById('input');
  
  let textArray = inputElement.value.split('.').filter(s => s !== '');
  let resultDiv = document.getElementById('output');

  while(textArray.length > 0){
    let text = textArray.splice(0,3).join('. ') + '.';
    let p = document.createElement('p');
    p.textContent = text;
    resultDiv.appendChild(p);
  }
}