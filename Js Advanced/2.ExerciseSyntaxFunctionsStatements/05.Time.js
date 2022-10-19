function time(steps, metersPerStep, speedKH) {

    let distance = steps * metersPerStep;
    let speed = speedKH * 1000 / 3600;
    let rest = Math.floor(distance / 500) * 60;
    let time = (distance / speed) + rest;

    let hours = Math.floor(time / 3600).toFixed(0).padStart(2, 0);
    let minutes = Math.floor(time / 60).toFixed(0).padStart(2, 0);
    let sec = (time % 60).toFixed(0).padStart(2, 0);
    console.log(`${hours}:${minutes}:${sec}`);
}

time(4000, 0.60, 5);