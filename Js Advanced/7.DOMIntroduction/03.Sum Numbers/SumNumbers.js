function calc() {
    let firstNumberElelement = document.getElementById('num1');
    let secondNumberElelement = document.getElementById('num2');

    let firstNumber = Number(firstNumberElelement.value);
    let secondNumber = Number(secondNumberElelement.value);
    let sum = firstNumber + secondNumber;

    let resultElelemt = document.getElementById('sum');
    resultElelemt.value = sum;
}
