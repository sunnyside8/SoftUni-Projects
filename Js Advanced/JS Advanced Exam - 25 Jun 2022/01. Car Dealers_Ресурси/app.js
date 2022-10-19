window.addEventListener("load", solve);

function solve() {
  let buttonPublishEl = document.getElementById('publish');

  let tableBodyToAppendElement = document.getElementById('table-body');
  let tableSoldElement = document.getElementById('cars-list');



  buttonPublishEl.addEventListener('click', publishButton);

  const input = {
    make: document.getElementById('make'),
    model: document.getElementById('model'),
    year: document.getElementById('year'),
    fuel: document.getElementById('fuel'),
    originalCost: document.getElementById('original-cost'),
    sellingPrice: document.getElementById('selling-price')
  }



  function publishButton(event) {
    event.preventDefault();

    if (!input.make.value || !input.model.value || !input.year.value || !input.fuel.value || !input.sellingPrice.value || !input.originalCost.value) {
      return
    }

    if (Number(input.originalCost.value) > Number(input.sellingPrice.value)) {
      return
    }

    let trNewEl = document.createElement('tr');
    trNewEl.className = 'row';

    trNewEl.appendChild(createElement('td', input.make.value));
    trNewEl.appendChild(createElement('td', input.model.value));
    trNewEl.appendChild(createElement('td', input.year.value));
    trNewEl.appendChild(createElement('td', input.fuel.value));
    trNewEl.appendChild(createElement('td', input.originalCost.value));
    trNewEl.appendChild(createElement('td', input.sellingPrice.value));

    let tdNewEl = document.createElement('td');

    let editButton = createElement('button', 'Edit', 'action-btn edit');
    tdNewEl.appendChild(editButton);

    let sellButton = createElement('button', 'Sell', 'action-btn sell');
    tdNewEl.appendChild(sellButton);

    trNewEl.appendChild(tdNewEl)

    tableBodyToAppendElement.appendChild(trNewEl);

    Object.values(input).forEach(i => i.value = '');

    editButton.addEventListener('click', editButtonFunc);
    sellButton.addEventListener('click', sellButtonFunc)


    function editButtonFunc(event) {
      let parrentRowOfEditClicked = event.target.parentElement.parentElement;

      let arrayOfTr = parrentRowOfEditClicked.children;

      input.make.value = arrayOfTr[0].textContent;
      input.model.value = arrayOfTr[1].textContent;
      input.year.value = arrayOfTr[2].textContent;
      input.fuel.value = arrayOfTr[3].textContent;
      input.originalCost.value = arrayOfTr[4].textContent;
      input.sellingPrice.value = arrayOfTr[5].textContent;

      parrentRowOfEditClicked.remove();

    }

    function sellButtonFunc(event) {
      let parrentRowOfEditClicked = event.target.parentElement.parentElement;

      let arrayOfTr = parrentRowOfEditClicked.children;
      let makeAndModel = `${arrayOfTr[0].textContent} ${arrayOfTr[1].textContent}`;
      let year = arrayOfTr[2].textContent;
      let priceDiff = Number(arrayOfTr[5].textContent) - Number(arrayOfTr[4].textContent);

      let liNewEl = document.createElement('li');
      liNewEl.className = 'each-list';

      liNewEl.appendChild(createElement('span', makeAndModel))
      liNewEl.appendChild(createElement('span', year))
      liNewEl.appendChild(createElement('span', priceDiff))

      tableSoldElement.appendChild(liNewEl);

      let profitEl = document.getElementById('profit').textContent;


      let total = Number(profitEl.slice(0, -1)) + priceDiff;
      document.getElementById('profit').textContent = `${total.toFixed(2)}`;

      parrentRowOfEditClicked.remove();


    }
  };

  function createElement(type, content, className) {
    const element = document.createElement(type);
    element.textContent = content;
    if (className) {
      element.className = className;
    }

    return element;
  }


}
