function generateReport() {
    let rows = document.querySelectorAll('tbody tr');

    let allObjects = [];


    for (const row of rows) {
        console.log('next');
        let arr = Array.from(row.children);
        let employee = arr[0].textContent;
        let deparment = arr[1].textContent;
        let status = arr[2].textContent;
        let dateHired = arr[3].textContent;
        let benefits = arr[4].textContent;
        let salary = arr[5].textContent;
        let rating = arr[6].textContent;


        allObjects.push({
            employee, deparment, status, dateHired, benefits, salary
        });
    }

    let ckeckedBoxes = document.getElementsByTagName('checkbox');
    for (const box of ckeckedBoxes) {
        if (box.checked) {
            console.log(box.name);
        }

    }
}