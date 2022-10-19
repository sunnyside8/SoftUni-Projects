function lowest(input){

    let products=[];

    while(input.length > 0){
        let [town,product,price] = input.shift().split(' | ');

        if(products.filter(x => x.product === product).length > 0){
                
            let obj = products.find(x => x.product ===  product);

            if(obj.price > Number(price)){
                obj.price = Number(price);
                obj.town = town;
            }

        } else{
            let object = {product,town,price:Number(price)};
            products.push(object);
        }
    }

    for (const product of products) {
        console.log(`${product.product} -> ${product.price} (${product.town})`);
    }
}
lowest(['Sample Town | Sample Product | 1000',
'Sample Town | Orange | 2',
'Sample Town | Peach | 1',
'Sofia | Orange | 3',
'Sofia | Peach | 2',
'New York | Sample Product | 1000.1',
'New York | Burger | 10']
);