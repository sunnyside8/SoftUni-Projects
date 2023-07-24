function solve() {
    const label = document.querySelector('#info span');
    const departBtn = document.getElementById('depart');
    const arriveBtn = document.getElementById('arrive');

    let stop = {
        next: 'depot'
    }

    async function depart() {
        departBtn.disabled = true;
        const url = `http://localhost:3030/jsonstore/bus/schedule/${stop.next}`;
        const res = await fetch(url);
        console.log(res);

        if (res.status !== 200) {
            label.textContent = `Error!`;
            departBtn.disabled = true;
            arriveBtn.disabled = true;
        }

        stop = await res.json();

        label.textContent = `Next stop ${stop.name}`;

        arriveBtn.disabled = false;

    }

    function arrive() {

        label.textContent = `Arriving at ${stop.name}`;

        departBtn.disabled = false;
        arriveBtn.disabled = true;
    }

    return {
        depart,
        arrive
    };
}

let result = solve();