function arr(input){

    input = input.sort((a,b) => a.length-b.length || a.localeCompare(b));

  input.forEach(el=> console.log(el));
}
arr(['alpha', 
'beta', 
'gamma']
)