window.addEventListener("load", solve);

function solve() {
  const input = {
    fname: document.getElementById('first-name'),
    lname: document.getElementById('last-name'),
    age: document.getElementById('age'),
    title: document.getElementById('story-title'),
    genre: document.getElementById('genre'),
    story: document.getElementById('story'),
  }

  let publishButton = document.getElementById('form-btn');
  let mainDiv = document.getElementById('main');

  let previewList = document.getElementById('preview-list');

  publishButton.addEventListener('click', publishButtonAction);


  function publishButtonAction(ev) {
    ev.preventDefault();

    if (!input.fname.value || !input.lname.value || !input.age.value || !input.title.value || !input.story.value) {
      return
    }

    let liElement = createElement('li', '', 'story-info');

    let artickleEl = createElement('article', '');
    artickleEl.appendChild(createElement('h4', `Name: ${input.fname.value} ${input.lname.value}`));
    artickleEl.appendChild(createElement('p', `Age: ${input.age.value}`));
    artickleEl.appendChild(createElement('p', `Title: ${input.title.value}`));
    artickleEl.appendChild(createElement('p', `Genre: ${input.genre.value}`));
    artickleEl.appendChild(createElement('p', input.story.value));

    liElement.appendChild(artickleEl);

    let saveButton = createElement('button', 'Save Story', 'save-btn');
    //   saveButton.disabled = false;
    let editButton = createElement('button', 'Edit Story', 'edit-btn');
    //    editButton.disabled = false;
    let deleteButton = createElement('button', 'Delete Story', 'delete-btn');
    //   deleteButton.disabled = false;
    liElement.appendChild(saveButton);
    liElement.appendChild(editButton);
    liElement.appendChild(deleteButton);

    previewList.appendChild(liElement);

    Object.values(input).forEach(i => i.value = '');

    publishButton.disabled = true;

    editButton.addEventListener('click', editArticle);
    saveButton.addEventListener('click', saveStoryClicked);
    deleteButton.addEventListener('click', deleteButClicked);

    function editArticle(ev) {
      publishButton.disabled = false;
      let array = ev.currentTarget.parentElement;

      let givenElement = Array.from(array.querySelector('article').children);

      let firstName = givenElement[0].textContent.split(' ')[1];
      let lastName = givenElement[0].textContent.split(' ')[2];
      let age = givenElement[1].textContent.substring(5);
      let title = givenElement[2].textContent.substring(7);
      let genre = givenElement[3].textContent.substring(7);
      let story = givenElement[4].textContent;

      input.fname.value = firstName;
      input.lname.value = lastName;
      input.age.value = age;
      input.title.value = title;
      input.genre.value = genre;
      input.story.value = story;

      array.remove();
      // TYK!!!!!!!!!!!!!!!!
      // saveButton.disabled = true;
      // editButton.disabled = true;
    }

    function saveStoryClicked() {
      mainDiv.innerHTML = '<h1>Your scary story is saved!</h1>'

    }

    function deleteButClicked(ev) {
      let array = ev.currentTarget.parentElement;
      array.remove();

      publishButton.disabled = false;
    }
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


