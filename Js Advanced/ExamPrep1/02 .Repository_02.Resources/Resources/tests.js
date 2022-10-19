let { Repository } = require("./solution.js");
let { expect } = require('chai');

describe("Repository tests", function () {
    let entity = {
        name: "Pesho",
        age: 22,
        birthday: new Date(1998, 0, 7)
    };
    let properties = {
        name: "string",
        age: "number",
        birthday: "object"
    };
    describe("Initizialization", function () {
        it("Should add props property on init", function () {
            let repo = new Repository(properties);
            expect(repo).to.have.property('props');
            expect(repo.props).to.deep.equal(properties);
        });
        it("Should have property data on init", function () {
            let repo = new Repository(properties);
            expect(repo).to.have.property('data');
            expect(typeof repo.data).is.equal('object');
            expect(repo.data).instanceOf(Map);
        });
    });

    describe("AddEntity", function () {
        it('Should return zero if first entity is addded', function () {
            let repository = new Repository(properties);

            expect(repository.add(entity)).to.equal(0);
            expect(repository.add(entity)).to.equal(1);
        })

        it('Should store valid entity in data map', function () {
            let repository = new Repository(properties);
            repository.add(entity)
            expect(repository.data.get(0)).to.equal(0);
        })


    });
    describe("Get count", function () {
        it('Should return number of entries', function () {
            let repository = new Repository({});

            expect(repository.count).is.equal(0);
        });

    });
});
