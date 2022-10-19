function toggle() {
     
    let button = document.getElementsByClassName('button')[0];
    let textDiv = document.getElementById('extra');
    let a = document.getElementsByClassName('button');

    button.textContent = button.textContent === 'More' ? 'Less' : 'More';

    textDiv.style.display = textDiv.style.display === 'block' ? 'none' : 'block' ;
    
}
