class Garden {

  constructor(spaceAvailable) {

    this.spaceAvailable = spaceAvailable;
    this.plants = [];
    this.storage = [];

  }

  addPlant(plantName, spaceRequired) {
    if (this.spaceAvailable < spaceRequired) {
      throw new Error(`Not enough space in the garden.`);
    }

    this.spaceAvailable -= spaceRequired;
    this.plants.push({ plantName, spaceRequired, ripe: false, quantity: 0 });

    return `The ${plantName} has been successfully planted in the garden.`;
  }

  ripenPlant(plantName, quantity) {
    if (!this.plants.some(x => x.plantName == plantName)) {
      throw new Error(`There is no ${plantName} in the garden.`);
    }

    let plant = this.plants.find(x => x.plantName == plantName);

    if (plant.ripe === true) {
      throw new Error(`The ${plantName} is already ripe.`);
    }

    if (quantity <= 0) {
      throw new Error(`The quantity cannot be zero or negative.`);
    }

    plant.ripe = true;
    plant.quantity += quantity;

    return quantity === 1 ? `${quantity} ${plantName} has successfully ripened.`
      : `${quantity} ${plantName}s have successfully ripened.`

  }

  harvestPlant(plantName) {
    if (!this.plants.some(x => x.plantName == plantName)) {
      throw new Error(`There is no ${plantName} in the garden.`);
    }

    let plant = this.plants.find(x => x.plantName == plantName);

    if (plant.ripe === false) {
      throw new Error(`The ${plantName} cannot be harvested before it is ripe.`);
    }

    let indexOfPlant = this.plants.findIndex(x => x.plantName == plantName);

    this.storage.push({
      plantName: plant.plantName,
      quantity: plant.quantity
    });
    this.spaceAvailable += plant.spaceRequired;
    this.plants.splice(indexOfPlant, 1);

    return `The ${plantName} has been successfully harvested.`;

  }

  generateReport() {
    let strings = [];
    strings.push(`The garden has ${this.spaceAvailable} free space left.`);

    let line = 'Plants in the garden: ' + this.plants.map(x => x.plantName).sort((a, b) => a.localeCompare(b)).join(', ');
    strings.push(line);

    let line2 = "Plants in storage: The storage is empty.";

    if (this.storage.length > 0) {
      line2 = 'Plants in storage: ' + this.storage.map(x => `${x.plantName} (${x.quantity})`).join(', ');

    }
    strings.push(line2);

    return strings.join('\n');
  }
}


let myGarden = new Garden(250);

console.log(myGarden.addPlant("apple", 20));
console.log(myGarden.addPlant("orange", 200));
console.log(myGarden.addPlant("raspberry", 10));
console.log(myGarden.ripenPlant("apple", 10));
console.log(myGarden.ripenPlant("orange", 1));
console.log(myGarden.harvestPlant("orange"));
console.log(myGarden.generateReport());