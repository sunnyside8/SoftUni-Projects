function encodeAndDecodeMessages() {
    let textAreas = document.querySelectorAll('textarea');
    let buttons = document.querySelectorAll('button');

    buttons[0].addEventListener('click', encode);
    buttons[1].addEventListener('click', decode);

    function encode(e) {
        let encodedMessage = '';
        let input = textAreas[0].value;
        for (let index = 0; index < input.length; index++) {
            encodedMessage += String.fromCharCode(input[index].charCodeAt(0) + 1);
        }
        textAreas[1].value = encodedMessage;
        textAreas[0].value = '';

    }
    function decode(e) {
        let dencodedMessage = '';
        let input = textAreas[1].value;
        for (let index = 0; index < input.length; index++) {
            dencodedMessage += String.fromCharCode(input[index].charCodeAt(0) - 1);

        }

        textAreas[1].value = dencodedMessage;
    }


}