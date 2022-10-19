window.addEventListener("load", solve);

function solve() {
  const input = {
    title: document.getElementById('post-title'),
    category: document.getElementById('post-category'),
    content: document.getElementById('post-content')
  }

  let publishButton = document.getElementById('publish-btn');

  let viewListEl = document.getElementById('review-list');
  let publishListEl = document.getElementById('published-list');

  let clearButton = document.getElementById('clear-btn');


  publishButton.addEventListener('click', publishButtonPresss);
  clearButton.addEventListener('click', clearButtonFunction);


  function publishButtonPresss(ev) {
    ev.preventDefault();

    if (!input.title.value || !input.category.value || !input.content.value) {
      return
    }

    let liNewElement = document.createElement('li');
    liNewElement.setAttribute("class", "rpost");

    let articleNewElement = document.createElement('article');
    articleNewElement.appendChild(createElement('h4', input.title.value));
    articleNewElement.appendChild(createElement('p', `Category: ${input.category.value}`));
    articleNewElement.appendChild(createElement('p', `Content: ${input.content.value}`));

    liNewElement.appendChild(articleNewElement);

    let approveButton = createElement('button', 'Approve', 'action-btn approve');
    liNewElement.appendChild(approveButton);

    let editButton = createElement('button', 'Edit', 'action-btn edit');
    liNewElement.appendChild(editButton);

    viewListEl.appendChild(liNewElement);

    Object.values(input).forEach(i => i.value = '');

    editButton.addEventListener('click', editPost);
    approveButton.addEventListener('click', approvePost);

    function editPost(ev) {
      let array = ev.currentTarget.parentElement;

      let category = array.querySelectorAll('p')[0].textContent;
      let content = array.querySelectorAll('p')[1].textContent;

      console.log(array);
      input.title.value = array.querySelector('h4').textContent;
      input.category.value = category.substring(10);
      input.content.value = content.substring(9);

      array.remove();
    }

    function approvePost(ev) {
      let array = ev.currentTarget.parentElement;

      let liNewElement = document.createElement('li');
      liNewElement.setAttribute("class", "rpost");

      console.log(array);
      liNewElement.appendChild(array.querySelector('article'));

      publishListEl.appendChild(liNewElement);

      array.remove();
    }
  }

  function clearButtonFunction() {
    publishListEl.innerHTML = '';

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
