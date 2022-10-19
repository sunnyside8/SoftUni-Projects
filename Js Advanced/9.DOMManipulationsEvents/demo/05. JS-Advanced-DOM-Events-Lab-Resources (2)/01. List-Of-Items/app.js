function addItem() {
    let inputText = document.getElementById('newItemText').value;

    let ulElement = document.getElementById('items');

    let li = document.createElement('li');
    li.textContent = inputText;
    ulElement.appendChild(li);

    document.getElementById('newItemText').value = "";
}