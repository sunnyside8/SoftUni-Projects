class SmartHike {

  constructor(username) {
    this.username = username;
    this.goals = {};
    this.listOfHikes = [];
    this.resources = 100;
  }

  addGoal(peak, altitude) {
    if (this.goals[peak]) {
      return `${peak} has already been added to your goals`;
    }

    this.goals[peak] = altitude;
    return `You have successfully added a new goal - ${peak}`;
  }

  hike(peak, time, difficultyLevel) {
    if (!this.goals[peak]) {
      throw new Error(`${peak} is not in your current goals`);
    }

    if (this.resources <= 0) {
      throw new Error(`You don't have enough resources to start the hike`);
    }

    let diffrence = this.resources - (time * 10);

    if (diffrence < 0) {
      return "You don't have enough resources to complete the hike";
    }

    this.resources = diffrence;
    this.listOfHikes.push({ peak, time, difficultyLevel });
    return `You hiked ${peak} peak for ${time} hours and you have ${this.resources}% resources left`;
  }

  rest(time) {
    let newPower = time * 10;

    if (newPower + this.resources >= 100) {
      this.resources = 100;
      return `Your resources are fully recharged. Time for hiking!`;
    } else {
      this.resources += newPower;
      return `You have rested for ${time} hours and gained ${newPower}% resources`;
    }
  }

  showRecord(criteria) {
    if (this.listOfHikes.length === 0) {
      return `${this.username} has not done any hiking yet`
    }

    if (criteria === 'all') {
      let string = [];
      string.push("All hiking records:");
      for (const hike of this.listOfHikes) {
        string.push(`${this.username} hiked ${hike.peak} for ${hike.time} hours`);
      }
      return string.join('\n');
    }

    let list = this.listOfHikes.filter(x => x.difficultyLevel === criteria);
    if (list.length === 0) {
      return `${this.username} has not done any ${criteria} hiking yet`;
    }

    let bestHikeTime = 1000000;
    let bestHikeObj = null;

    for (const obj of list) {
      if (obj.time < bestHikeTime) {
        bestHikeTime = obj.time;
        bestHikeObj = obj;
      }
    }

    return `${this.username}'s best ${criteria} hike is ${bestHikeObj.peak} peak, for ${bestHikeTime} hours`;
  }
}
const user = new SmartHike('Vili');

console.log(user.addGoal("Musala", 2925));
console.log(user.hike("Musala", 8, "hard"));
console.log(user.showRecord("easy"));
console.log(user.addGoal("Vihren", 2914));
console.log(user.hike("Vihren", 4, "hard"));
console.log(user.showRecord("hard"));
console.log(user.addGoal("Rui", 1706));
console.log(user.hike("Rui", 3, "easy"));
console.log(user.showRecord("all"));