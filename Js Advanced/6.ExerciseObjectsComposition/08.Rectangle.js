function rectangle(width, height, color) {
    color = color.charAt(0).toUpperCase() + color.slice(1);
    return {
        width: Number(width),
        height: Number(height),
        color: color,
        calcArea: function () {
            return Number(this.width)*Number(this.height) }
    }

}

let rect = rectangle(4, 5, 'red');
console.log(rect.width);
console.log(rect.height);
console.log(rect.color);
console.log(rect.calcArea());
