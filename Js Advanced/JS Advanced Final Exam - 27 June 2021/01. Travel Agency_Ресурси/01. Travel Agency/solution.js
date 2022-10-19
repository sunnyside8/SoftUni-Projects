window.addEventListener('load', solution);

function solution() {
  const input = {
    name: document.getElementById('fname'),
    email: document.getElementById('email'),
    phone: document.getElementById('phone'),
    address: document.getElementById('address'),
    code: document.getElementById('code')
  }

  let submitButton = document.getElementById('submitBTN');
  let editButton = document.getElementById('editBTN');
  let continueButton = document.getElementById('continueBTN');

  let previewInfoSection = document.getElementById('infoPreview');
  let divBlock = document.getElementById('block');

  submitButton.addEventListener('click', clickedEvent);
  editButton.addEventListener('click', editEvent);
  continueButton.addEventListener('click', completeEvenet);


  function clickedEvent(ev) {
    ev.preventDefault();

    if (!input.name.value || !input.email.value) {
      return
    }


    previewInfoSection.appendChild(createElement('li', `Full Name: ${input.name.value}`));
    previewInfoSection.appendChild(createElement('li', `Email: ${input.email.value}`));
    previewInfoSection.appendChild(createElement('li', `Phone Number: ${input.phone.value}`));
    previewInfoSection.appendChild(createElement('li', `Address: ${input.address.value}`));
    previewInfoSection.appendChild(createElement('li', `Postal Code: ${input.code.value}`));

    Object.values(input).forEach(i => i.value = '');

    let button = ev.currentTarget;
    button.disabled = true;

    editButton.disabled = false;
    continueButton.disabled = false;

    console.log(button);

  }
  function editEvent(ev) {
    let listElements = previewInfoSection.children;
    console.log(listElements);
    input.name.value = listElements[0].textContent.substring(11);
    input.email.value = listElements[1].textContent.substring(7);
    input.phone.value = listElements[2].textContent.substring(14);
    input.address.value = listElements[3].textContent.substring(9);
    input.code.value = listElements[4].textContent.substring(13);

    previewInfoSection.innerHTML = '';

    submitButton.disabled = false;

    editButton.disabled = true;
    continueButton.disabled = true;
  }

  function completeEvenet() {
    divBlock.innerHTML = '<h3> Thank you for your reservation!</h3>';
  }

  function createElement(type, content, className) {
    const element = document.createElement(type);
    element.textContent = content;
    if (className) {
      element.className = className;
    }

    return element;
  }
}
