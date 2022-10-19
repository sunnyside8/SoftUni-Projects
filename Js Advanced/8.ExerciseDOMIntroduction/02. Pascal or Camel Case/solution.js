function solve() {

let textElememnt = document.querySelector('#text');
let namingConventionElememnt = document.querySelector('#naming-convention');

let text = textElememnt.value;
let namingConvention = namingConventionElememnt.value;

let result = applyNamingConvention(text,namingConvention);
let spanElememnt = document.getElementById('result');
spanElememnt.textContent = result;

function applyNamingConvention(text,convention){
  const conventionSwitch = {
    'Pascal Case' : ()=> text
    .toLowerCase()
    .split(' ')
    .map(x => x[0].toUpperCase() + x.slice(1))
    .join(''),
    'Camel Case' : ()=> text
    .toLowerCase()
    .split(' ')
    .map((x,i) =>x = i !==0 ? x[0].toUpperCase() + x.slice(1) : x)
    .join(''),
    default: () =>'Error!'
  };

  return (conventionSwitch[convention] || conventionSwitch.default)();
}

}