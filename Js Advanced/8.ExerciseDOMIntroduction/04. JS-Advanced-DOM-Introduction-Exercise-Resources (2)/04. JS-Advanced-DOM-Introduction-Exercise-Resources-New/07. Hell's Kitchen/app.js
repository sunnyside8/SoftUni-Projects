function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick() {
      let inputArr = JSON.parse(document.querySelector('#inputs textarea')).value;
      let avgSalary = 0;
      let totalSalary = 0;
      let currentSalary = 0;
      let bestName = '';

      let output = {};

      for (const inputElement of inputArr) {
         let restourantInfo = inputElement.split(' - ');
         let restourantName = restourantInfo.shift();
         let workersData = restourantInfo[0].split(', ');

         for (const worker of workersData) {
            let [name, salary] = worker.split(' ');

            if (output.hasOwnProperty(restourantName)) {
               output[restourantName] = {};
            } else {
               output[restourantName][name] = Number[salary]
            }
         }
      }

      let entries = Object.entries(output);

      for (const entry of object) {
         let key = entry[0];
         let values = Object.entries(entry[1]);
         for (const [name, salary] of values) {
            totalSalary += salary;
         }

         avgSalary = totalSalary / values.length;

         if (avgSalary > currentSalary) {
            currentSalary = avgSalary;
            bestName = key;
            totalSalary = 0;
         }
      }

      let print = '';

      let result = Object.entries(output[bestName]);
      result.forEach(w => print += `Name: ${w[0]} With Salary: ${w[1]}`);

      document.querySelector('#bestRestaurant')
         .textContent = `Name: ${bestName} Average Salary: 
         ${currentSalary.toFixed(2)} Best Salary: ${result[0][1]}`;

      document.querySelector('#workers p').textContent = print;
   }
}