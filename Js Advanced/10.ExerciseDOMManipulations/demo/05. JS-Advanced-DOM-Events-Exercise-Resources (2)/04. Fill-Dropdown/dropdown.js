function addItem() {
    let newItemTextEl = document.getElementById('newItemText');
    let newItemValue = document.getElementById('newItemValue');

    let optionEl = document.createElement('option');
    optionEl.textContent = newItemTextEl.value;
    optionEl.value = newItemValue.value;

    let selectEl = document.getElementById('menu');
    selectEl.appendChild(optionEl);

    newItemTextEl.value = '';
    newItemValue.value = '';
}