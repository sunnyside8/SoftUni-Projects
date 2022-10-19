function deleteByEmail() {

    let emailInputElelement = document.querySelector('input[name="email"]');
    let emailCellElements = document.querySelectorAll('tr td:nth-of-type(2)');
    
    let resultElememnt  = document.getElementById('result')

    let emailElements = Array.from(emailCellElements);
    let targetElememnt = emailElements.find(x => x.textContent == emailInputElelement.value);

    if(targetElememnt){
        targetElememnt.parentNode.remove();
        resultElememnt.textContent = 'Deleted'
    } else{
        resultElememnt.textContent = 'Not found'
    }

}