function cards(face,suit){
   // let allSuits = ['S' ,'H','D','C'];
    let allFaces = ['2', '3', '4', '5','6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];

    let suits = {
        S:'\u2660' ,
        H:'\u2665 ',
        D:'\u2666 ',
        C:'\u2663 '
    }
    if(!allFaces.includes(face) || !suits[suit]){
        throw new Error('Error')
    }

    let card = {
        face,
        suit,
        toString(){
            console.log(this.face + suits[this.suit]);
        }
    }   

    return card;
};
let card = cards('1', 'S');
card.toString()