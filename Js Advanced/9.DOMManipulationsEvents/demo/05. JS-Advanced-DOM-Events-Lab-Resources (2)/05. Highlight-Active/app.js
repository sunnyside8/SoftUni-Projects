function focused() {

  let divsInputesEl = document.querySelectorAll('div [type=text]');
  for (const iterator of divsInputesEl) {
    iterator.addEventListener('click', getsFocused);
    iterator.addEventListener('blur', makeBlurAgain);
  }

  function getsFocused(e) {
    e.target.parentElement.className = 'focused';
  }

  function makeBlurAgain(e) {
    e.target.parentElement.className = '';
  }
}