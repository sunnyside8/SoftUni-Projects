function subtract() {
    let firstElememntValue = document.getElementById('firstNumber').value;
    let secondElementValue = document.getElementById('secondNumber').value;

    let resultElememnt = document.getElementById('result');
    resultElememnt.textContent = Number(firstElememntValue) - Number(secondElementValue);
    console.log(firstElememntValue, secondElementValue);
}