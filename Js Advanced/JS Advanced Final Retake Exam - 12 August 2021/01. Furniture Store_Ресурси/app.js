window.addEventListener('load', solve);

function solve() {
    const addButtonElements = document.getElementById('add');

    const modelElement = document.getElementById('model');
    const yearElement = document.getElementById('year');
    const descriptionEl = document.getElementById('description');
    const priceElement = document.getElementById('price');

    const furnitureListEl = document.getElementById('furniture-list');

    addButtonElements.addEventListener('click', addClickHandler);

    function addClickHandler(ev) {
        ev.preventDefault();
        let model = modelElement.value;
        let description = descriptionEl.value;
        let year = Number(yearElement);
        let price = Number(priceElement.value);

        if (!model || !description) {
            return
        }

        if (year <= 0 || price <= 0) {
            return
        }

        let rowElement = document.createElement('tr');

        let modelDataElememnt = document.createElement('td');
        let priceCellElement = document.createElement('td');
        let actionsCellElement = document.createElement('td');
        let infoButton = document.createElement('button');
        let buyButton = document.createElement('button');
        let contentsRowElement = document.createElement('tr');
        let yearContentElement = document.createElement('td');
        let descriptionElCreate = document.createElement('td');
        let totalPriceEl = document.querySelector('.total-price');


        modelDataElememnt.textContent = model;
        priceCellElement.textContent = price.toFixed(2);

        infoButton.textContent = 'More Info';
        infoButton.classList.add('moreBtn');

        infoButton.addEventListener('click', (e) => {

            if (e.currentTarget.textContent == 'MoreInfo') {
                e.currentTarget.textContent = 'Less Info'
            } else {
                e.currentTarget.textContent = 'MoreInfo'
            }
        })

        buyButton.textContent = 'Buy it';
        buyButton.classList.add('buyBtn');
        buyButton.addEventListener('click', (e) => {
            let currentTotalprice = Number(totalPriceEl.textContent);
            let total = currentTotalprice + price;
            totalPriceEl.textContent = total.toFixed(2);
            rowElement.remove();
            contentsRowElement.remove();
        })

        actionsCellElement.appendChild(infoButton);
        actionsCellElement.appendChild(buyButton);

        rowElement.classList.add('info');


        rowElement.appendChild(modelDataElememnt);
        rowElement.appendChild(priceCellElement);
        rowElement.appendChild(actionsCellElement);

        yearContentElement.textContent = `Year : ${year}`;
        descriptionElCreate.setAttribute('colspan', 3);
        descriptionElCreate.textContent = `Description: ${description}`;

        contentsRowElement.classList.add('hide');
        contentsRowElement.style.display = 'contents';

        contentsRowElement.appendChild(yearContentElement);
        contentsRowElement.appendChild(descriptionElCreate);

        furnitureListEl.appendChild(rowElement);
        furnitureListEl.appendChild(contentsRowElement);
    }
}
