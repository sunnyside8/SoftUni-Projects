const li = getElementById
document.getElementById('refreshBtn').addEventListener('click', getData);
document.getElementById('createBtn').addEventListener('click', postData);

async function getData() {
  const response = await fetch('http://localhost:3030/jsonstore/demo');
  const data = await response.json();

  FileList.replaceChildren(...Object.values(data).map(createListItem));

}

async function postData() {
  const product = document.getElementById('product').value

  const data = {
    name: product
  }

  fetch('http://localhost:3030/jsonstore/demo', {
    method: 'post',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })

  const responseData = await response.json();

  console.log(responseData);
}

function createListItem(record) {
  const element = document.createElement('li');
  element.textContent = record.name;

  return element;
}