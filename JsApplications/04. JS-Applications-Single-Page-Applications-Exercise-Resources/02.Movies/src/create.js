import { homePage } from "./home.js";
import { showView } from "./util.js";

const createSection = document.querySelector('#add-movie');

const form = createSection.querySelector('form');
form.addEventListener('submit', onSubmit);

export function createPage() {
  showView(createSection);
}

async function onSubmit(event) {
  event.preventDefault();
  const formdata = new FormData(form);

  const title = formdata.get('title');
  const description = formdata.get('description');
  const img = formdata.get('imageUrl');

  await createMovie(title, description, img);
  form.reset();
  homePage();
}

async function createMovie(title, description, img) {
  const user = JSON.parse(localStorage.getItem('user'));
  await fetch('http://localhost:3030/data/movies', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'X-Authorization': user.accessToken
    },
    body: JSON.stringify({ title, description, img })
  })
}

