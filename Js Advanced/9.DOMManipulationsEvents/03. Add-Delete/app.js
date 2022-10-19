function addItem() {
    let itemsElememnt = document.getElementById('items');
    let inputElememnt = document.getElementById('newItemText');

    let liElement = document.createElement('li');
    liElement.textContent = inputElememnt.value;

    inputElememnt.value = '';
    
    let deleteElememnt = document.createElement('a');
    deleteElememnt.href = '#';
    deleteElememnt.textContent = '[Delete]';
    deleteElememnt.addEventListener('click',(e) => {
        e.currentTarget.parentElement.remove();
    })

    liElement.appendChild(deleteElememnt);
    itemsElememnt.appendChild(liElement);

}