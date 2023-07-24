async function getInfo() {
    const stopNameElment = document.getElementById('stopName');
    const timeTableElement = document.getElementById('buses');

    const stopId = document.getElementById('stopId').value;
    const url = `http://localhost:3030/jsonstore/bus/businfo/${stopId}`;
    const submitBtn = document.getElementById('submit');

    try {
        stopNameElment.textContent = "LoADING...";
        timeTableElement.replaceChildren();

        const res = await fetch(url);
        const data = await res.json();

        if (res.status !== 200) {
            throw new Error('Stop ID not found')
        }

        stopNameElment.textContent = data.name; ``

        Object.entries(data.buses).forEach(bus => {
            const liElememnt = document.createElement('li');
            liElememnt.textContent = `Bus ${bus[0]} arrives in ${bus[1]} minutes`
            timeTableElement.appendChild(liElememnt);
        })
    } catch (error) {
        stopNameElment.textContent = "Error";
    }
}