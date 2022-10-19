function lockedProfile() {


  let showMoreElements = document.querySelectorAll('button');
  for (const button of showMoreElements) {
    button.addEventListener('click', function (ev) {
      let patentDivEl = ev.target.parentElement;
      let unlocked = patentDivEl.querySelector('input[value="unlock"]').checked;

      if (unlocked) {
        let info = Array.from(patentDivEl.querySelectorAll('div'))
          .find(p => p.id.includes('HiddenFields'));

        if (ev.currentTarget.textContent == 'Show more') {
          ev.target.textContent = 'Hide it';
          info.style.display = 'block';
        } else {
          ev.target.textContent = 'Show more';
          info.style.display = 'none';
        }
      }
    })
  }

}