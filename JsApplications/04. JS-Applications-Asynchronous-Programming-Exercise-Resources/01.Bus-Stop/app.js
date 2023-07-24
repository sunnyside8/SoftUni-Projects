function getInfo() {
    let baseUrl = "http://localhost:3030/jsonstore/bus/businfo"

    let input = document.getElementById('stopId');

    let ulElement = document.getElementById('buses');
    let divElement = document.getElementById('stopName');

    fetch(`${baseUrl}/${input.value}`)
        .then(response => response.json())
        .then(data => {
            let buses = data.buses;
            let name = data.name;

            divElement.textContent = name;
            ulElement.innerHTML = '';
            Object.keys(buses).forEach(bus => {
                let liElement = document.createElement('li');
                liElement.textContent = `Bus ${bus} arrives in ${buses[bus]} minutes`;
                ulElement.appendChild(liElement);
            })
        })
        .catch(error => {
            divElement.textContent = 'Error';
            ulElement.innerHTML = '';
        })


}