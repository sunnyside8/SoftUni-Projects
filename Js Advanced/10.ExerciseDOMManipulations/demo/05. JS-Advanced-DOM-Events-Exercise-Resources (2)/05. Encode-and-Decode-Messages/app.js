function encodeAndDecodeMessages() {
    let textAreas = document.querySelectorAll('textarea');
    let buttonsElements = document.querySelectorAll('button');
    let messageEl = textAreas[0];
    let decodedMessageEl = textAreas[1];

    let encodedMsg = '';
    let decodedMsg = '';

    buttonsElements[0].addEventListener('click', function () {
        messageEl.value.split('')
            .forEach(e => encodedMsg += String.fromCharCode(e.charCodeAt(0) + 1));

        messageEl.value = '';
        decodedMessageEl.value = encodedMsg;

    })

    buttonsElements[1].addEventListener('click', function () {
        decodedMessageEl.value.split('')
            .forEach(e => decodedMsg += String.fromCharCode(e.charCodeAt(0) - 1));

        decodedMessageEl.value = '';
        messageEl.value = decodedMsg;

    })

}