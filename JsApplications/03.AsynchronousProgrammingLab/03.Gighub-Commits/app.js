async function loadCommits() {
    const username = document.getElementById('username').value;
    const repo = document.getElementById('repo').value;
    const list = document.getElementById('commits');

    try {
        const response = await fetch(`https://api.github.com/repos/${username}/${repo}/commits`);

        if (response.ok == false) {
            throw new Error(`${response.status} ${response.statusText}`);
        }

        const data = await response.json();
        list.innerHTML = '';

        for (const { commit } of data) {
            list.innerHTML += `<li>${commit.author.name}: ${commit.message}</li>`;
        }

    } catch (error) {
        list.innerHTML = `Error: ${error.message}`;
    }
}