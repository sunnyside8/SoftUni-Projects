function extract(content) {
let contentElememnt = document.getElementById(content);

let pattern = /\(([^(]+)\)/g;

let matches = contentElememnt.textContent.matchAll(pattern);
let result = [];
for (const match of matches) {
    console.log(match[0]);
    result.push(match[1])
}
 return result.join('; ');
}