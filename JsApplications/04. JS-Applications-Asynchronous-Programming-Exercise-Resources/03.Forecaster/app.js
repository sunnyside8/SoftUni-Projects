function attachEvents() {
    let inputElement = document.getElementById('location');
    let getButton = document.getElementById('submit');
    let divDisplay = document.getElementById('forecast');
    let currentDiv = document.getElementById('current');
    let upcomingDiv = document.getElementById('upcoming');
    let baseUrl = 'http://localhost:3030/jsonstore/forecaster';

    let sunny = '&#x2600';
    let partlySunny = '&#x26C5';
    let overcast = '&#x26C5';
    let rain = '&#x2614';
    let degrees = '&#176';
    let code = '';

    let divEelementUpcoming = document.createElement('div');
    let divEelementCurrent = document.createElement('div');

    getButton.addEventListener('click', (e) => {
        divEelementUpcoming.innerHTML = '';
        divEelementCurrent.innerHTML = '';

        divEelementUpcoming.setAttribute('class', 'forecast-info');
        divEelementCurrent.setAttribute('class', 'forecasts');

        divDisplay.style.display = 'inline';

        fetch(`${baseUrl}/locations`)
            .then(response => response.json())
            .then(data => {
                data.forEach(locationInfoObject => {
                    if (locationInfoObject.name === inputElement.value) {
                        return code = locationInfoObject.code;
                    }
                });

                fetch(`${baseUrl}/today/${code}`)
                    .then(response => response.json())
                    .then(data => {
                        let spanGrooup = document.createElement('span');
                        let conditionSpan = document.createElement('span');
                        let temperaturSpan = document.createElement('span');
                        let locationSpan = document.createElement('span');
                        let spanWithIcon = document.createElement('span');

                        locationSpan.textContent = data.name;
                        temperaturSpan.innerHTML = `${data.forecast.low}${degrees}/${data.forecast.high}${degrees}`;
                        conditionSpan.textContent = data.forecast.condition;

                        let condition = data.forecast.condition;
                        if (condition == 'Sunny') {
                            spanWithIcon.innerHTML = sunny;
                        } else if (condition == 'Partly sunny') {
                            spanWithIcon.innerHTML = partlySunny
                        } else if (condition == 'Overcast') {
                            spanWithIcon.innerHTML = overcast
                        } else if (condition == 'Rain') {
                            spanWithIcon.innerHTML = rain
                        }

                        spanGrooup.appendChild(locationSpan);
                        spanGrooup.appendChild(temperaturSpan);
                        spanGrooup.appendChild(conditionSpan);
                        divEelementCurrent.appendChild(spanWithIcon);
                        divEelementCurrent.appendChild(spanGrooup)

                        currentDiv.appendChild(divEelementCurrent);


                    })
                    .catch(error => console.log(error));

                fetch(`${baseUrl}/upcoming/${code}`)
                    .then(response => response.json())
                    .then(data => {
                        let nextdays = data.forecast;

                        nextdays.forEach(x => {

                            let spanGrooup = document.createElement('span');
                            let conditionSpan = document.createElement('span');
                            let temperaturSpan = document.createElement('span');
                            let locationSpan = document.createElement('span');
                            let spanWithIcon = document.createElement('span');

                            spanWithIcon.setAttribute('class', 'symbol');
                            spanGrooup.setAttribute('class', 'upcoming');
                            temperaturSpan.setAttribute('class', 'forecast-data');
                            conditionSpan.setAttribute('class', 'forecast-data');

                            locationSpan.textContent = x.name;
                            temperaturSpan.innerHTML = `${x.low}${degrees}/${x.high}${degrees}`;
                            conditionSpan.textContent = x.condition;

                            let condition = x.condition;

                            if (condition == 'Sunny') {
                                spanWithIcon.innerHTML = sunny;
                            } else if (condition == 'Partly sunny') {
                                spanWithIcon.innerHTML = partlySunny
                            } else if (condition == 'Overcast') {
                                spanWithIcon.innerHTML = overcast
                            } else if (condition == 'Rain') {
                                spanWithIcon.innerHTML = rain
                            }

                            spanGrooup.appendChild(spanWithIcon);
                            spanGrooup.appendChild(temperaturSpan);
                            spanGrooup.appendChild(conditionSpan);
                            divEelementUpcoming.appendChild(spanGrooup);
                            upcomingDiv.appendChild(divEelementUpcoming);

                        })
                    })
            })
    })
}

attachEvents();