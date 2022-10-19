let { cinema } = require("./cinema.js");
let { assert } = require('chai');


describe("Cinema", function () {

  describe("showMovies", function () {
    it("Empty Array", function () {
      assert.equal(cinema.showMovies([]), 'There are currently no movies to show.');
    });

    it("Empty Array", function () {
      assert.equal(cinema.showMovies(["Film", "Vtori Film"]), 'Film, Vtori Film');
      assert.equal(cinema.showMovies(["Film"]), 'Film');
    });

  });

  describe("showMovies", function () {
    it("Not resent", function () {
      assert.throw(() => cinema.ticketPrice("Film"), 'Invalid projection type.');
    });

    it("Empty Array", function () {
      assert.equal(cinema.ticketPrice("Premiere"), 12.00);
      assert.equal(cinema.ticketPrice("Normal"), 7.50);
      assert.equal(cinema.ticketPrice("Discount"), 5.50);
    });
  })

  describe("showMovies", function () {
    it("Not resent", function () {
      assert.equal(cinema.swapSeatsInHall(-2, -2), "Unsuccessful change of seats in the hall.");
      assert.equal(cinema.swapSeatsInHall(0, 0), "Unsuccessful change of seats in the hall.");
      assert.equal(cinema.swapSeatsInHall(2, -2), "Unsuccessful change of seats in the hall.");
      assert.equal(cinema.swapSeatsInHall(-2, 2), "Unsuccessful change of seats in the hall.");
      assert.equal(cinema.swapSeatsInHall(0, 2), "Unsuccessful change of seats in the hall.");
      assert.equal(cinema.swapSeatsInHall(2, 0), "Unsuccessful change of seats in the hall.");
      assert.equal(cinema.swapSeatsInHall(40, 30), "Unsuccessful change of seats in the hall.");
      assert.equal(cinema.swapSeatsInHall(16, 30), "Unsuccessful change of seats in the hall.");
      assert.equal(cinema.swapSeatsInHall(30, 16), "Unsuccessful change of seats in the hall.");
      assert.equal(cinema.swapSeatsInHall("I am String", 16), "Unsuccessful change of seats in the hall.");
      assert.equal(cinema.swapSeatsInHall(10, "I am String"), "Unsuccessful change of seats in the hall.");
      assert.equal(cinema.swapSeatsInHall("I am String", "I am String"), "Unsuccessful change of seats in the hall.");

    });

    it("Okay", function () {
      assert.equal(cinema.swapSeatsInHall(1, 16), "Successful change of seats in the hall.");
      assert.equal(cinema.swapSeatsInHall(19, 15), "Successful change of seats in the hall.");
      assert.equal(cinema.swapSeatsInHall(20, 15), "Successful change of seats in the hall.");
      assert.equal(cinema.swapSeatsInHall(17, 20), "Successful change of seats in the hall.");

    });
  })

});
