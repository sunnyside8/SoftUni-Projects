const expect = require('chai').expect;
const sum = require('./04.Sumo');

describe('Sum of Numbers', () =>{
    it('Should return the correct sum', () => {
        let numbers = [1,2,3,4,5];

        let actualSum = sum(numbers);
        let expected = 15;

        expect(actualSum).to.equal(expected);
    });
    it('Should return the correct sum with  negative numbers', () => {
        let numbers = [-1,-2,-3,-4,-5];

        let actualSum = sum(numbers);
        let expected = -15;

        expect(actualSum).to.equal(expected);
    });
});


