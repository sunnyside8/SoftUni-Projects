async function attachEvents() {
    let Sunny = '&#x2600';
    let PartlySunny = '&#x26C5';
    let Overcast = '&#x2601';
    let Rain = '&#x2614';
    let Degrees = '&#176';

    let url = `http://localhost:3030/jsonstore/forecaster/locations`
    let inputField = document.getElementById('location');
    let button = document.getElementById('submit');
    let currentConditionsDiv = document.getElementById('current');
    let upcomingDiv = document.getElementById('upcoming');
    let forecast = document.getElementById('forecast');



    button.addEventListener('click', startFetchingData);

    function startFetchingData() {
        forecast.style.display = 'inline';


        fetch(url)
            .then((response) => response.json())
            .then((data) => {

                let code = data.filter(x => x.name == inputField.value);


                console.log(code);

            })
            .catch(err => {
                forecast.textContent = 'Error';
                upcomingDiv.style.display = 'None';
            })
    }



}

attachEvents();