function solve() {
  const [input, output] = Array.from(document.querySelectorAll('textarea'));

  function generate() {
    document.querySelectorAll(input.value);

    for (const item of data) {
      const row = document.createElement('tr');
      const c1 = document.createElement('td');
      const img = document.createElement('img');
      img.scr = item.img;
      c1.appendChild(img);

      const c2 = document.createElement('td');
      const p = document.createElement('p');
      p.textContent = item.name
      c2.appendChild(p);



    }

  }
}