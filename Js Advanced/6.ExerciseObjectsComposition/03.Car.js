function car(object) {

    let resultCar = {};
    let engine = {};
    let carriage = {};

    resultCar.model = object.model;

    if (object.power <= 90) {
        engine.power = 90;
        engine.volume = 1800;
    } else if (object.power <= 120) {
        engine.power = 120;
        engine.volume = 2400;
    } else if (object.power <= 200) {
        engine.power = 200;
        engine.volume = 3500;
    }

    carriage.type = object.carriage;
    carriage.color = object.color;
    

    if(object.wheelsize % 2 == 0){
        object.wheelsize-=1;
    }
     resultCar.wheels = [object.wheelsize,object.wheelsize,object.wheelsize,object.wheelsize]
    resultCar.engine = engine;
    resultCar.carriage = carriage;

    return resultCar;

}
car({
    model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14
}
);