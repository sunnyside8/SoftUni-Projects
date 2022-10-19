function solve() {
  let input = document.getElementById('input').value;
  let output = document.getElementById('output');

  let sentances = input.split('.').filter(s => s.length != 0);

  while (sentances.length > 0) {
    let textForParagraph = sentances.splice(0, 3).join('. ') + '.';
    let parapraph = document.createElement('p');
    parapraph.textContent = textForParagraph;
    output.appendChild(parapraph);
  }
}