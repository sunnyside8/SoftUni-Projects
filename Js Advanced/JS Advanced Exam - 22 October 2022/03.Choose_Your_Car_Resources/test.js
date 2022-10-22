let { chooseYourCar } = require("./chooseYourCar.js");
let { assert } = require('chai');

describe("Car", function () {

  describe("choosingType", function () {
    it("Wrong Year", function () {
      assert.throw(() => chooseYourCar.choosingType("Sedan", "Pink", 1899), `Invalid Year!`);
      assert.throw(() => chooseYourCar.choosingType("Sedan", "Pink", 2023), `Invalid Year!`);
    });
    it("Not sedan", function () {
      assert.throw(() => chooseYourCar.choosingType("Kupe", "Pink", 2001), `This type of car is not what you are looking for.`);
    });

    it("Year not Okay", function () {
      assert.equal(chooseYourCar.choosingType("Sedan", "Pink", 2001), `This Sedan is too old for you, especially with that Pink color.`);
    })

    it("YearOkay", function () {
      assert.equal(chooseYourCar.choosingType("Sedan", "Pink", 2010), `This Pink Sedan meets the requirements, that you have.`);
      assert.equal(chooseYourCar.choosingType("Sedan", "Pink", 2015), `This Pink Sedan meets the requirements, that you have.`);
    })

  });
  describe("choosingType", function () {
    it("Wrong Input", function () {
      assert.throw(() => chooseYourCar.brandName("Sedan", "Pink"), "Invalid Information!");
      assert.throw(() => chooseYourCar.brandName(['BMW', 'Mercedes', 'Audi'], -1), "Invalid Information!");
      assert.throw(() => chooseYourCar.brandName(['BMW', 'Mercedes', 'Audi'], 3), "Invalid Information!");
      assert.throw(() => chooseYourCar.brandName(['BMW', 'Mercedes', 'Audi'], 4), "Invalid Information!");
    });

    it("Okay", function () {
      assert.equal(chooseYourCar.brandName(['BMW', 'Mercedes', 'Audi'], 1), `BMW, Audi`);
      assert.equal(chooseYourCar.brandName(['BMW', 'Mercedes'], 1), `BMW`);
    })

  })

  describe(" carFuelConsumption", function () {
    it("Wrong Year", function () {

      //TYK!!!!
      assert.throw(() => chooseYourCar.carFuelConsumption("I am String", "I am String"), "Invalid Information!");
      assert.throw(() => chooseYourCar.carFuelConsumption(-1, -1), "Invalid Information!");
      assert.throw(() => chooseYourCar.carFuelConsumption(0, 0), "Invalid Information!");
    });

    it("Not Efficient car", function () {
      assert.equal(chooseYourCar.carFuelConsumption(100, 10), `The car burns too much fuel - 10.00 liters!`);
    })

    it("Efficient car", function () {
      assert.equal(chooseYourCar.carFuelConsumption(100, 3), `The car is efficient enough, it burns 3.00 liters/100 km.`);
      assert.equal(chooseYourCar.carFuelConsumption(100, 7), `The car is efficient enough, it burns 7.00 liters/100 km.`);
    })

  })

}); 