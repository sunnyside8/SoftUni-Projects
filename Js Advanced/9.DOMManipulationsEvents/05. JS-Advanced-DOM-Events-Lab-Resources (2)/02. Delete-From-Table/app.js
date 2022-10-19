function deleteByEmail() {
    const value = document.querySelector('input[name="email"]').value;

    const rows = Array.from(document.querySelectorAll('tbody tr'));

    let found = false;
    for (const row of rows) {
        if (row.children[1].textContent == value) {
            const parent = row.parentElement;
            parent.removeChild(row);
            found = true;
        }
    }

    if (found) {
        document.getElementById('result').textContent = 'Deleted'
    } else {
        document.getElementById('result').textContent = 'Not found.'
    }
}