window.addEventListener('load', solve);

function solve() {
    const addButtonElememnt = document.getElementById('add');
    
    const modelInputElememnt = document.getElementById('model');
    const yearInputElememnt = document.getElementById('year');
    const descriptionInputElememnt = document.getElementById('description');
    const priceInputElememnt = document.getElementById('price');
    const furnitureList = document.getElementById('furniture-list');

    addButtonElememnt.addEventListener('click',addClickHandler);
   
    function addClickHandler(e){
        e.preventDefault();
        let model = modelInputElememnt.value;
        let description = descriptionInputElememnt.value;
        let year = Number(yearInputElememnt.value);
        let price = Number(priceInputElememnt.value);

        if( !model|| !description){
            return;
        }

        if(year <= 0 || price <= 0){
            return
        }

        let rowElememnt= document.createElement('tr');

        let modelCellElememnt= document.createElement('td');
        let priceCellElememnt= document.createElement('td');
        let actionsCellElememnt = document.createElement('td');
        let infoButtonElememnt = document.createElement('button');
        let buyButtonElememnt = document.createElement('button');
        let contentsRowElememnt = document.createElement('tr');
        let yearContentElememnt = document.createElement('td');
        let descriptionContentElement = document.createElement('td');
        let totalPriceElememnt = document.querySelector('.total-price');


        modelCellElememnt.textContent = model;
        priceCellElememnt.textContent = (price).toFixed(2);

        infoButtonElememnt.textContent = 'More Info';
        infoButtonElememnt.classList.add('moreBtn');
        infoButtonElememnt.addEventListener('click',(e) =>{
            if(e.currentTarget.textContent == 'More Info'){
                e.currentTarget.textContent = 'Less Info';
                contentsRowElememnt.style.display = 'contents';
            } else{
                e.currentTarget.textContent = 'More Info';
                contentsRowElememnt.style.display = 'none';
            }
            

        })
        buyButtonElememnt.textContent = 'Buy it';
        buyButtonElememnt.classList.add('buyBtn');
        buyButtonElememnt.addEventListener('click',(e) =>{
            let currentTotalPrice = Number(totalPriceElememnt.textContent);
            let totalPrice = currentTotalPrice + price;
            totalPriceElememnt.textContent = totalPrice.toFixed(2);
            rowElememnt.remove();
            contentsRowElememnt.remove
        })

        actionsCellElememnt.appendChild(infoButtonElememnt);
        actionsCellElememnt.appendChild(buyButtonElememnt);

        rowElememnt.classList.add('info');

        rowElememnt.appendChild(modelCellElememnt);
        rowElememnt.appendChild(priceCellElememnt);
        rowElememnt.appendChild(actionsCellElememnt);

        yearContentElememnt.textContent = `Year: ${year}`;
        descriptionContentElement.setAttribute('colspan',3);
        descriptionContentElement.textContent = `Description: ${description}`;

        contentsRowElememnt.classList.add('hide');
        contentsRowElememnt.style.display = 'none';

        contentsRowElememnt.appendChild(yearContentElememnt);
        contentsRowElememnt.appendChild(descriptionContentElement);

        furnitureList.appendChild(rowElememnt);
        furnitureList.appendChild(contentsRowElememnt)
        


    }
}
