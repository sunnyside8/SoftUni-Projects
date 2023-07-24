import { homePage } from "./home.js";
import { loginPage } from "./login.js";
import { registerPage } from "./register.js";
import { createPage } from "./create.js";
import { updateNav } from "./util.js";

const routes = {
  '/': homePage,
  '/login': loginPage,
  '/logout': logout,
  '/register': registerPage,
  '/create': createPage
}

document.querySelector('nav').addEventListener('click', onNavigate)
document.querySelector('#add-movie-button a').addEventListener('click', onNavigate)

function onNavigate(event) {
  if (event.target.tagName == 'A' && event.target.href) {
    event.preventDefault();
    const url = new URL(event.target.href);

    const view = routes[url.pathname];

    if (typeof view == 'function') {
      view();
    }
  }
}

function logout() {
  localStorage.removeItem('user');
  updateNav();
}

updateNav();
homePage();

