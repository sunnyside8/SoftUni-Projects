function subtract() {
    
    let firstElememnt = document.getElementById('firstNumber').value;
    let secondNumber = document.getElementById('secondNumber').value;

    let answear = Number(firstElememnt) - Number(secondNumber);
    
    
    let resultDiv = document.getElementById('result');
    resultDiv.textContent = answear;

}