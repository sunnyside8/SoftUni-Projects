import { showView, spinner } from "./util.js";
const detailsSection = document.querySelector('#movie-example');

export function detailsPage(id) {
  showView(detailsSection);
  displayMovie(id)
}

async function displayMovie(id) {
  const user = JSON.stringify(localStorage.getItem('user'));

  detailsSection.replaceChildren(spinner());

  const [movie, likes, ownLike] = await Promise.all([
    getMovie(id), getLikes(id), getOwnLikes(id, user)])

  detailsSection.replaceChildren(createMovieCard(movie, user, likes, ownLike));
}

function createMovieCard(movie, user, likes, ownLike) {
  const element = document.createElement('div');
  element.className = 'container';
  element.innerHTML = `                <div class="row bg-light text-dark"><h1>Movie title: ${movie.title}</h1><div class="col-md-8">
      <img class="img-thumbnail" src="${movie.img}"
          alt="Movie">
  </div>
  <div class="col-md-4 text-center">
      <h3 class="my-3 ">Movie Description</h3>
      <p>${movie.description}</p>
      ${createControls(movie, user, likes, ownLike)}</div>
</div>`

  return element
}

function createControls(movie, user, likes, ownLike) {
  const isOwner = user && user._id === movie._ownerId;

  let controls = [];

  if (isOwner) {
    controls.push(`<a class="btn btn-danger" href="#">Delete</a>`);
    controls.push(`<a class="btn btn-warning" href="#">Edit</a>`);
  } else if (user && ownLike == false) {
    controls.push(`<a a class="btn btn-primary" href = "#" > Like</a>`);
  }
  controls.push(`<span class="enrolled-span">Liked ${likes}</span>`);
  return controls.join('');
}


async function getMovie(id) {
  const response = await fetch(`http://localhost:3030/data/movies/${id}`);
  const movie = await response.json();
  return movie;
}

async function getLikes(id) {
  const response = await fetch(`http://localhost:3030/data/likes?where=movieId%3D%22${id}%22&distinct=_ownerId&count`);
  const likes = await response.json();
  return likes;
}

async function getOwnLikes(movieId, user) {
  if (!user) {
    return false;
  } else {
    const userId = user._id;
    const response = await fetch(`http://localhost:3030/data/likes?where=movieId%3D%22${movieId}%22%20and%20_ownerId%3D%22${userId}%22`);
    const like = await response.json();

    return like.length > 0;
  }

}