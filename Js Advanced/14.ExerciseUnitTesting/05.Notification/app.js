function notify(message) {

  let notifiction = document.getElementById('notification');
  notifiction.innerText = message;
  notifiction.style.display = 'block';

  setTimeout(function(){
    notifiction.style.display = 'none'
  },2000)


  notifiction.addEventListener('click', (event) => {
    event.target.style.display = 'none';
  })
}