function extractText() {
    const items = Array.from(document.querySelectorAll('li'));
    const result = items.map(e => e.textContent).join('\n');

    document.getElementById('result').value = result;
}