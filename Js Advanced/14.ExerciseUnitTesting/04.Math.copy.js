const mathEnforcer = require('./04.Math');
const {assert} = require('chai');

describe('Test Math task', () => {

    describe('add five func test', ()=>{
        
        it('should return undefined with string',()=>{
            assert(mathEnforcer.addFive('TEST') === undefined)
        })
        it('should return undefined with arr',()=>{
            assert(mathEnforcer.addFive([]) === undefined)
        })
        it('should return undefined with obj',()=>{
            assert(mathEnforcer.addFive({}) === undefined)
        })

        it('should return true value 1',()=>{
            assert(mathEnforcer.addFive(5),10)
        })
        it('should return true value 2',()=>{
            assert(mathEnforcer.addFive(5.5),10.5)
        })
        it('should return true value 3',()=>{
            assert(mathEnforcer.addFive(-5) === 0)
        })
    })

    describe('subtr 10', ()=>{
        it('should return undefined with string',()=>{
            assert(mathEnforcer.subtractTen('TEST') === undefined)
        })
        it('should return undefined with arr',()=>{
            assert(mathEnforcer.subtractTen([]) === undefined)
        })
        it('should return undefined with obj',()=>{
            assert(mathEnforcer.subtractTen({}) === undefined)
        })

        it('should return true value 1',()=>{
            assert(mathEnforcer.subtractTen(5),-5)
        })
        it('should return true value 2',()=>{
            assert(mathEnforcer.subtractTen(5.5),-5.5)
        })
        it('should return true value 3',()=>{
            assert(mathEnforcer.subtractTen(-5),-15)
        })
    })

    describe('sum two num', ()=>{
        it('Two positive numbers',()=>{
            assert(mathEnforcer.sum(10,20),30)
        })
        it('Two negative numbers',()=>{
            assert(mathEnforcer.sum(-10,-20),-30)
        })

        it('Two decimal numbers',()=>{
            assert(mathEnforcer.sum(10.2,20.3),30.5)
        })

        it('First wrong',()=>{
            assert(mathEnforcer.sum('',-20.3) === undefined)
        })

        it('Second wrong',()=>{
            assert(mathEnforcer.sum(10,'') === undefined)
        })

        it('Two wrong',()=>{
            assert(mathEnforcer.sum('',) === undefined)
        })
    })
})