function solve() {

    let infoElemet = document.querySelector('.info');
    let depart = document.getElementById('depart');
    let arriveButton = document.getElementById('arrive');

    let busStop = {
        next: 'depot'
    }

    function depart() {
        depart.disabled = true;
        let url = `http://localhost:3030/jsonstore/bus/schedule/${busStop.next}`;

        fetch(url)
            .then(response => response.json())
            .then(data => {
                busStop = JSON.parse(JSON.stringify(data));
                infoElemet.textContent = `Next stop ${busStop.name}`;

            })
            .catch(error => console.log(error);)
        arriveButton.disabled = false;
    }

    function arrive() {

        infoElemet.textContent = `Arriving at ${busStop.name}`;
        depart.disabled = false;
        arriveButton.disabled = true;

    }

    return {
        depart,
        arrive
    };
}

let result = solve();