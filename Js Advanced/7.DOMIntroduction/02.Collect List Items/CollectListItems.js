function extractText() {
    let ulElememnt = document.getElementById('items');

    console.log(ulElememnt.textContent);

    let textAreaElememnt = document.getElementById('result');
    textAreaElememnt.textContent = ulElememnt.textContent;
}