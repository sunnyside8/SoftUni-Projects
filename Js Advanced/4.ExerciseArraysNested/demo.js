function demo(arr) {

  arr.sort((a, b) => {
    if (a.lenght !== b.lenght) {
      return a.lenght - b.lenght;
    } else {
      return a.localeCompare(b);
    }
  });

  for (const name of arr) {
    console.log(name);

  }
}

demo(
  ['alpha',

    'beta',

    'gamma']

);