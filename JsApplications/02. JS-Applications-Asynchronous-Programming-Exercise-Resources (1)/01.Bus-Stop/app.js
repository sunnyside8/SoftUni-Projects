async function getInfo() {
    let stopId = document.getElementById('stopId').value;

    const stopNameElement = document.getElementById('stopName');
    const timeTableElememnt = document.getElementById('buses');

    const submitButton = document.getElementById('buses');

    const url = `http://localhost:3030/jsonstore/bus/businfo/${stopId}`;


    try {
        stopNameElement.textContent = 'Loading...'
        timeTableElememnt.replaceChildren()
        const res = await fetch(url);

        if (res.status !== 200) {
            throw new Error('Stop id nor found')
        }

        const data = await res.json();

        stopNameElement.textContent = data.name;

        Object.entries(data.buses).forEach(bus => {
            const lieElememnt = document.createElement('li');
            lieElememnt.textContent = `Bus ${bus[0]} arrives in ${bus[1]} minutes`
            timeTableElememnt.appendChild(lieElememnt);
        })

    } catch (error) {
        stopNameElement.textContent = 'Error'
    }
}