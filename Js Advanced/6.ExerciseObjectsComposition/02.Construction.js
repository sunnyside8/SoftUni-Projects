function crew(worker){

    if(worker.dizziness){
        worker.levelOfHydrated += 0.1*worker.weight*worker.experience;
        worker.dizziness =false;

    }


    return worker;

}
console.log(crew({ weight: 80,
    experience: 1,
    levelOfHydrated: 0,
    dizziness: true }
  ));