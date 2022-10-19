const isOddOrEven = require('./02.Even');
const {assert} = require('chai');

describe('isOddOrEven function tests', ()=> {

   it ('should return undefined if parameter is number',()=>{
        assert.equal(isOddOrEven(10),undefined);
    });

    it ('should return undefined if parameter is array',()=>{
        assert.equal(isOddOrEven({}),undefined);
    });

    it ('should return undefined if parameter is object',()=>{
        assert.equal(isOddOrEven([]),undefined);
    });

    it ('should return even',()=>{
        assert.equal(isOddOrEven('Hi'),'even');
    });

    it ('should return odd',()=>{
        assert.equal(isOddOrEven('Hello'),'odd');
    });

});