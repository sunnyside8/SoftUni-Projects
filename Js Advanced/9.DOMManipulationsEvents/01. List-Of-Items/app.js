function addItem() {
    let inputElememnt = document.getElementById('newItemText');
    let itemsElelemnt = document.getElementById('items');


    let liElememnt = document.createElement('li');
        liElememnt.textContent = inputElememnt.value;

        itemsElelemnt.appendChild(liElememnt);

}