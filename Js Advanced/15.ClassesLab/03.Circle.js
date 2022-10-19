class Circle{
    constructor(radius){
        this.radius = radius;
    }

    get area(){
        return  Math.PI * this.radius ** 2
    }

}

let circle = new Circle(2);
console.log(circle.area);