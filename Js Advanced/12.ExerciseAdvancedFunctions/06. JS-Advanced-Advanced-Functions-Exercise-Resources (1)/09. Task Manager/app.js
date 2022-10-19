function solve() {
    document.getElementById('add').addEventListener('click', addTask);
    const input = {
        name: document.getElementById('task'),
        description: document.getElementById('description'),
        date: document.getElementById('date')
    }

    const [_, openSection, progressSection, finishSection] = Array.from(document.querySelectorAll('section'))
        .map(e => e.children[1])


    function addTask(event) {
        event.preventDefault();

        const article = document.createElement('article');
        article.appendChild(createElement('h3', input.name.value));
        article.appendChild(createElement('p', `Description: ${input.description.value}`));
        article.appendChild(createElement('p', `Due Date: ${input.date.value}`));

        const div = createElement('div', '', 'flex');
        const startButton = createElement('button', 'Start', 'green');
        div.appendChild(startButton);

        const deleteButton = createElement('button', 'Delete', 'red');
        div.appendChild(deleteButton)

        const finishButton = createElement('button', 'Finish', 'orange');

        article.appendChild(div);
        openSection.appendChild(article);

        Object.values(input).forEach(i => i.value = '');

        startButton.addEventListener('click', onStart)
        deleteButton.addEventListener('click', onDelete)
        finishButton.addEventListener('click', onFinish)

        function onDelete() {
            article.remove();
        }

        function onStart() {
            startButton.remove();
            div.appendChild(finishButton);

            progressSection.appendChild(article);
        }

        function onFinish() {
            div.remove()
            finishSection.appendChild(article);
        }
    }

    function createElement(type, content, className) {
        const element = document.createElement(type);
        element.textContent = content;
        if (className) {
            element.className = className;
        }

        return element;
    }
}