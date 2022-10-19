function addItem() {
    const input = document.getElementById('newItemText');

    const lieElement = document.createElement('li');
    lieElement.textContent = input.value;

    const deleteButton = document.createElement('a');
    deleteButton.textContent = '[Delete]';
    deleteButton.href = '#';
    lieElement.appendChild(deleteButton);

    deleteButton.addEventListener('click', onDelete);

    document.getElementById('items').appendChild(lieElement);

    input.value = '';


}

function onDelete(event) {
    event.target.parentElement.remove();
}
