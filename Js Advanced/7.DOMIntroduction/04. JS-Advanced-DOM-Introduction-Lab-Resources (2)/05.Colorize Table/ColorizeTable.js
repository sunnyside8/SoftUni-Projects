function colorize() {

    let list = document.getElementsByTagName('tr');
    //   document.querySelectorAll('li:nth-child(2n)');

    for (i = 1; i < list.length; i += 2) {
        list[i].style.background = "teal";
    }
}