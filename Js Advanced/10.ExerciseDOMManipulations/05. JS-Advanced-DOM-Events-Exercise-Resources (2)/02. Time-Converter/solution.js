function attachEventsListeners() {

    let dayBtn = document.getElementById('daysBtn');
    let hoursBtn = document.getElementById('hoursBtn');
    let minutesBtn = document.getElementById('minutesBtn');
    let secondsBtn = document.getElementById('secondsBtn');

    let days = document.getElementById('days');
    let hours = document.getElementById('hours');
    let minutes = document.getElementById('minutes');
    let seconds = document.getElementById('seconds');

    let rations = {
        days: 1,
        hours: 24,
        minutes: 1440,
        seconds: 86400
    }

    dayBtn.addEventListener('click', onConver);
    hoursBtn.addEventListener('click', onConver);
    minutesBtn.addEventListener('click', onConver);
    secondsBtn.addEventListener('click', onConver);

    function convert(value, unit) {
        let days = value / rations[unit];
        return {
            days: days,
            hours: days * rations.hours,
            minutes: days * rations.minutes,
            seconds: seconds * rations.hours
        }
    }

    function onConver(event) {
        let input = event.target.parentElement.querySelector('input[type="text"]');
        console.log(input);
        let time = convert(Number(input.value), input.id);

        days.value = time.days;
        hours.value = time.hours;
        minutes.value = time.minutes;
        seconds.value = time.seconds;
    }

}