function addItem() {
    //select input field 

    const content = document.getElementById('newItemText').value;

    const lieEl = document.createElement('li');

    lieEl.textContent = content;
    document.getElementById('items').appendChild(lieEl);

    document.getElementById('newItemText').value = '';
}