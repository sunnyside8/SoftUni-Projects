function addItem() {
    let inputText = document.getElementById('newItemText').value;

    let ulElement = document.getElementById('items');

    let li = document.createElement('li');
    li.textContent = inputText;
    let deleteEl = document.createElement('a');
    let link = document.createTextNode('[Delete]');
    li.appendChild(deleteEl);
    ulElement.appendChild(li);

    deleteEl.appendChild(link);
    deleteEl.href = '#';
    deleteEl.addEventListener('click', function (e) {
        e.currentTarget.parentElement.remove();
    })

    document.getElementById('newItemText').value = "";
}