let { testNumbers } = require("./testNumbers.js");
let { assert } = require('chai');


describe("Numbers", function () {

  describe("Sum Numbers…", function () {
    it("chek if params are numbers…", function () {
      assert.equal(testNumbers.sumNumbers("I am string", "I am String"), undefined);
      assert.equal(testNumbers.sumNumbers("I am string", 1), undefined);
      assert.equal(testNumbers.sumNumbers(1, "I am String"), undefined);
    });

    it("okay params", function () {
      assert.equal(testNumbers.sumNumbers(1, 1), 2);
      assert.equal(testNumbers.sumNumbers(-1, -1), -2);
      assert.equal(testNumbers.sumNumbers(1.123, 1.111), 2.23);
    })

  });

  describe("numberChecker…", function () {
    it("number is Nan", function () {
      assert.throw(() => testNumbers.numberChecker("I am String"), 'The input is not a number!');
      assert.throw(() => testNumbers.numberChecker({}), 'The input is not a number!');
    });

    it("even", function () {
      assert.equal(testNumbers.numberChecker(1), 'The number is odd!');
      assert.equal(testNumbers.numberChecker(2), 'The number is even!');
      assert.equal(testNumbers.numberChecker(0), 'The number is even!');
    })
  })

  describe("numberChecker…", function () {
    it("sum", function () {
      assert.equal(testNumbers.averageSumArray([1, 1, 1]), 1);
      assert.equal(testNumbers.averageSumArray([-2, -2, -2]), -2);
      assert.equal(testNumbers.averageSumArray([1]), 1);
    })
  })

}); 