window.addEventListener('load', solve);

function solve() {

    const input = {
        type: document.getElementById('type-product'),
        description: document.getElementById('description'),
        name: document.getElementById('client-name'),
        phone: document.getElementById('client-phone')
    }

    let sendFormButton = document.querySelector('form button');
    let clearButton = document.getElementsByClassName('clear-btn')[0];

    let recievedOrdersSection = document.getElementById('received-orders');
    let completeOrders = document.getElementById('completed-orders');


    sendFormButton.addEventListener('click', clickSendButton);
    clearButton.addEventListener('click', clearButtonClick);

    function clickSendButton(ev) {
        ev.preventDefault();
        if (!input.type.value || !input.description.value || !input.name.value || !input.phone.value) {
            return
        }

        if (input.type.value !== 'Phone' && input.type.value !== 'Computer') {
            return
        }

        let newDiv = createElement('div', '', 'container');
        newDiv.appendChild(createElement('h2', `Product type for repair: ${input.type.value}`));
        newDiv.appendChild(createElement('h3', `Client information: ${input.name.value}, ${input.phone.value}`));
        newDiv.appendChild(createElement('h4', `Description of the problem: ${input.description.value}`));

        let startButton = createElement('button', 'Start repair', 'start-btn');
        newDiv.appendChild(startButton);

        let finishtButton = createElement('button', 'Finish repair', 'finish-btn');
        finishtButton.disabled = true;
        newDiv.appendChild(finishtButton);

        recievedOrdersSection.appendChild(newDiv);

        Object.values(input).forEach(i => i.value = '');

        startButton.addEventListener('click', startRepairClicked);


        function startRepairClicked(ev) {

            let container = ev.currentTarget.parentElement;

            let but1 = container.querySelectorAll('button')[0];
            but1.disabled = true;

            let but2 = container.querySelectorAll('button')[1];
            but2.disabled = false;

            but2.addEventListener('click', moveTask);

            function moveTask() {

                container.removeChild(but1);
                container.removeChild(but2);

                completeOrders.appendChild(container);
            }

        }
    }

    function clearButtonClick() {

        let elements = ['<h2>Completed orders:</h2>', '<img src="./style/img/completed-order.png">', '<button class="clear-btn">Clear</button>'];

        completeOrders.innerHTML = elements.join('\n');
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