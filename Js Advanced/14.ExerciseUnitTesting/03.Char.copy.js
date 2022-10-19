const lookupChar = require('./03.Char');
const {assert} = require('chai');

describe('lookupChar test', ()=>{

    it('Return char at index',()=>{
        assert(lookupChar('Love',0),'L');
    });

    it('Return char at index',()=>{
        assert(lookupChar('Love',1),'o');
    });

    it('Return char at index',()=>{
        assert(lookupChar('L',0),'L');
    });

    it('Return when index over the string length',()=>{
        assert(lookupChar('Love',10),'Incorect Index');
    });

    it('Negative String Index',()=>{
        assert(lookupChar('Love',-10),'Incorect Index');
    });

    it('Return undefined if first param is not string',()=>{
        assert.equal(lookupChar(100,1),undefined);
    });

    it('Return char at index',()=>{
        assert(lookupChar('',0),'Incorect Index');
    });


    it('Return undefined if last param double',()=>{
        assert.equal(lookupChar('Love',1.46),undefined);
    });

    it('Return undefined if last param double',()=>{
        assert.equal(lookupChar(10,'10'),undefined);
    });
})

