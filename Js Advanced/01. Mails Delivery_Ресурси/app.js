function solve() {

  let buttonPublishEl = document.getElementById('add');
  let resetButtonEl = document.getElementById('reset');
  let sendEmailEl = document.querySelector('ul[class="sent-list"]');
  let listOfDeletedMail = document.querySelector('ul[class="delete-list"]');

  let listOfMailEl = document.getElementById('list');

  buttonPublishEl.addEventListener('click', addtoList);
  resetButtonEl.addEventListener('click', resetListener)


  const input = {
    recipientName: document.getElementById('recipientName'),
    title: document.getElementById('title'),
    message: document.getElementById('message')
  }

  function addtoList(ev) {
    ev.preventDefault();

    if (!input.title.value || !input.recipientName.value || !input.message.value) {
      return
    }

    let title = input.title.value;
    let recipientName = input.recipientName.value;
    let message = input.message.value;

    let liNewEl = document.createElement('li');

    liNewEl.appendChild(createElement('h4', `Title: ${title}`));
    liNewEl.appendChild(createElement('h4', `Recipient Name: ${recipientName}`));
    liNewEl.appendChild(createElement('span', message));

    let newButtonDivEl = createElement('div', '', 'list-action');

    let newSendButton = createElement('button', 'Send');
    newSendButton.type = 'submit';
    newSendButton.id = 'send'
    newButtonDivEl.appendChild(newSendButton);

    let newDeleteButton = createElement('button', 'Delete');
    newDeleteButton.type = 'submit';
    newDeleteButton.id = 'delete'
    newButtonDivEl.appendChild(newDeleteButton);

    liNewEl.appendChild(newButtonDivEl);

    listOfMailEl.appendChild(liNewEl);

    newSendButton.addEventListener('click', sendAction);
    newDeleteButton.addEventListener('click', deleteFromListOfMails);
    //    Object.values(input).forEach(i => i.value = '');

    function sendAction(ev) {
      let liArray = ev.currentTarget.parentElement.parentElement;
      let h4Array = Array.from(liArray.querySelectorAll('h4'));

      let emailTo = h4Array[1].textContent;

      let liAppandEl = createElement('li', '');

      liAppandEl.appendChild(createElement('span', `To: ${emailTo.substring(16)}`));
      liAppandEl.appendChild(createElement('span', h4Array[0].textContent));

      let newDiv = document.createElement('div')
      newDiv.className = 'btn';

      let buttonEl = createElement('button', 'Delete', 'delete');
      buttonEl.type = 'submit';

      newDiv.append(buttonEl);
      liAppandEl.append(newDiv);

      sendEmailEl.append(liAppandEl);

      listOfMailEl.removeChild(liArray);

      buttonEl.addEventListener('click', deleteOn);

      function deleteOn(ev) {
        let liArray = ev.currentTarget.parentElement.parentElement;
        let spanArray = Array.from(liArray.querySelectorAll('span'));

        let liAppandEl = createElement('li', '');
        liAppandEl.appendChild(createElement('span', spanArray[0].textContent));
        liAppandEl.appendChild(createElement('span', spanArray[1].textContent));

        listOfDeletedMail.appendChild(liAppandEl);

        liArray.remove();

      }
    }

    function deleteFromListOfMails(ev) {

      let liArray = ev.currentTarget.parentElement.parentElement;
      let h4Array = Array.from(liArray.querySelectorAll('h4'));

      let emailTo = h4Array[1].textContent;

      let liAppandEl = createElement('li', '');
      liAppandEl.appendChild(createElement('span', `To: ${emailTo.substring(16)}`));
      liAppandEl.appendChild(createElement('span', h4Array[0].textContent));

      listOfDeletedMail.appendChild(liAppandEl);

      liArray.remove();

    }

  }

  function resetListener(event) {
    event.preventDefault();
    Object.values(input).forEach(i => i.value = '');

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
solve()