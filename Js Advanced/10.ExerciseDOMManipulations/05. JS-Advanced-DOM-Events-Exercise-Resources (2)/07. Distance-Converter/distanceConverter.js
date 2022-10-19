function attachEventsListeners() {
    let buttonConvert = document.getElementById('convert');
    buttonConvert.addEventListener('click', onClick);

    let metricUnits = {
        km: 1000,
        m: 1,
        cm: 0.01,
        mm: 0.001,
        mi: 1609.34,
        yrd: 0.9144,
        ft: 0.3040,
        in: 0.0254
    }

    function onClick(e) {
        let fromValue = document.getElementById('inputUnits').value;
        let toValue = document.getElementById('outputUnits').value;

        let inputDistance = Number(document.getElementById('inputDistance').value);
        let outputDistanceEl = document.getElementById('outputDistance');

        let valueInMeters = inputDistance * metricUnits[fromValue];
        let convertedValue = valueInMeters / metricUnits[toValue];

        outputDistanceEl.value = convertedValue;
    }

}