let { library } = require("./library.js");
let { assert, expect } = require('chai');

describe("Library tests", function () {

  describe("Calc price book", function () {

    it("Wrong input", function () {

      assert.throw(() => library.calcPriceOfBook(1, "I am String"), 'Invalid input');
      assert.throw(() => library.calcPriceOfBook(1, 1), 'Invalid input');
      assert.throw(() => library.calcPriceOfBook('I am String', 'I am String'), 'Invalid input');

    });

    it("Year <= 1998", function () {
      assert.equal(library.calcPriceOfBook('Zaglavie', 1980), "Price of Zaglavie is 10.00");
      assert.equal(library.calcPriceOfBook('Zaglavie', 1970), "Price of Zaglavie is 10.00");
    });

    it("Year > 1998", function () {
      assert.equal(library.calcPriceOfBook('Zaglavie', 1981), "Price of Zaglavie is 20.00");
      assert.equal(library.calcPriceOfBook('Zaglavie', 2000), "Price of Zaglavie is 20.00");
    });

  });
  describe("findBook", function () {
    it("EmptyArray", function () {
      assert.throw(() => library.findBook([], "Zaglavie"), "No books currently available");
    });
    it("BookFound", function () {
      assert.equal(library.findBook(["Zaglavie"], "Zaglavie"), "We found the book you want.");
    });
    it("No such book found", function () {
      assert.equal(library.findBook(["Drygo Zaglavie", "Treto Zaglavie"], "Zaglavie"), "The book you are looking for is not here!");
    });

  });

  describe("arrangeTheBooks", function () {
    it("Number is no integer or less than 0", function () {
      assert.throw(() => library.arrangeTheBooks("Not integer"), "Invalid input");
      assert.throw(() => library.arrangeTheBooks(-3), "Invalid input");
    })

    it("Avalable space > count", function () {
      assert.equal(library.arrangeTheBooks(38), 'Great job, the books are arranged.');
      assert.equal(library.arrangeTheBooks(40), 'Great job, the books are arranged.');
    })

    it("Avalable space < count", function () {
      assert.equal(library.arrangeTheBooks(41), "Insufficient space, more shelves need to be purchased.");
      assert.equal(library.arrangeTheBooks(50), "Insufficient space, more shelves need to be purchased.");

    })

  })
}); 