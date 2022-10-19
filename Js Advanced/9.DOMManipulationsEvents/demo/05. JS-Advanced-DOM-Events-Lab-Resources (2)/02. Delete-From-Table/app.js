function deleteByEmail() {
    let input = document.querySelector('input').value;
    let result = document.getElementById('result');

    let allEmails = document.querySelectorAll('tbody tr');

    let flag = false;

    for (const row of allEmails) {
        let email = row.querySelectorAll('td')[1];

        if (email.textContent === input) {
            email.parentNode.parentNode.removeChild(row);
            flag = true;
            break;
        }
    }

    result.textContent = flag ? 'Deleted.' : 'Not found.';

}