function attachGradientEvents() {
    let gredient = document.getElementById('gradient');
    let result = document.getElementById('result');

    gredient.addEventListener('mousemove', function (e) {
        let power = e.offsetX / (e.target.clientWidth - 1)
        result.textContent = `${Math.trunc(power * 100)}%`

    })
}