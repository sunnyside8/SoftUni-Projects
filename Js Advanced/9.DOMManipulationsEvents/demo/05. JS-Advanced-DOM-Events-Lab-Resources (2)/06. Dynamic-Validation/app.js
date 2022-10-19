function validate() {
    let inputEl = document.querySelector('input');

    let email = inputEl.value;

    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/g;

    inputEl.addEventListener('input', function () {
        if (!email.match(regex)) {
            inputEl.className = 'error';
            return;
        }

        inputEl.className = '';
    })

}