function solve() {

  let [generateBtn, buyBtn] = Array.from(document.querySelectorAll('button'));
  generateBtn.addEventListener('click', generate);
  buyBtn.addEventListener('click', buy);


  function generate() {
    let input = JSON.parse(document.querySelector('textarea').value);
    input.forEach(x => {
      let tr = document.createElement('tr');
      let td1 = document.createElement('td');
      let img = document.createElement('img');
      img.src = x.img;
      td1.appendChild(img);
      tr.appendChild(td1);

      let td2 = document.createElement('td');
      let p = document.createElement('p');
      p.textContent = x.name;
      td2.appendChild(p);
      tr.appendChild(td2);

      let td3 = document.createElement('td');
      let p2 = document.createElement('p');
      p2.textContent = Number(x.price);
      td3.appendChild(p2);
      tr.appendChild(td3);

      let td4 = document.createElement('td');
      let p3 = document.createElement('p');
      p3.textContent = Number(x.decFactor);
      td4.appendChild(p3);
      tr.appendChild(td4);

      let td5 = document.createElement('td');
      let input = document.createElement('input');
      input.type = 'checkbox';
      td5.appendChild(input);
      tr.appendChild(td5);

      document.querySelector('tbody').appendChild(tr);
    });

  }

  function buy(e) {
    let checkboxes = Array.from(document.querySelectorAll('tbody input'))
      .filter(c => c.checked);
    let bought = [];
    let price = 0;
    let decoration = 0;

    checkboxes.forEach(x => {
      let parent = x.parentElement.parentElement;
      let data = Array.from(parent.querySelectorAll('p'));

      bought.push(data[0].textContent);
      price += Number(data[1].textContent);
      decoration += Number(data[2].textContent);
    })

    let output = document.querySelectorAll('textarea')[1];
    output.textContent += `Bought furniture: ${bought.join(', ')}\r\n`;
    output.textContent += `Total price: ${price.toFixed(2)}\r\n`;
    output.textContent += `Average decoration factor: ${decoration / checkboxes.length}`
  }
}