function solve() {
  let text = document.getElementById('text').value;
  let naming = document.getElementById('naming-convention').value;

  let result = '';

  let words = text.split(/(\s+)/).filter(x => x != ' ');

  if (naming == 'Camel Case') {
    words = transformArray(words);
    words[0] = words[0][0].toLowerCase() + words[0].substring(1);
  } else if (naming == 'Pascal Case') {
    words = transformArray(words);
  } else {
    return document.getElementById('result').textContent = 'Error!';
  }

  result = words.join('')
  document.getElementById('result').textContent = result;

  function transformArray(words) {
    for (let index = 0; index < words.length; index++) {
      words[index] = words[index].toLowerCase();
      words[index] = words[index][0].toUpperCase() + words[index].substring(1);
    }
    return words
  }
}