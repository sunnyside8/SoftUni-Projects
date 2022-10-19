function attachGradientEvents() {
   let gradientElement = document.getElementById('gradient');
   let resultElement = document.getElementById('result');

    const gradientMouseOverHandler = (e) =>{
        let percent = Math.floor((e.offsetX/e.target.offsetWidth) * 100);

        console.log(percent);
       resultElement.textContent = `${percent}%`;
    };

   gradientElement.addEventListener('mousemove',gradientMouseOverHandler)
}