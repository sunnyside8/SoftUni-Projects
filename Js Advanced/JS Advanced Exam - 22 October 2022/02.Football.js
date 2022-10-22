class footballTeam {

  constructor(clubName, country) {
    this.clubName = clubName;
    this.country = country;
    this.invitedPlayers = [];
  }

  newAdditions(footballPlayers) {
    let playerNamesArr = new Set;

    for (const playerLine of footballPlayers) {
      let tokens = playerLine.split('/');
      let name = tokens[0];

      let player = this.invitedPlayers.find(x => x.name == name);
      let playerValue = tokens[2];
      if (player === undefined) {
        let age = tokens[1];
        this.invitedPlayers.push({ name, age, playerValue });
        playerNamesArr.add(name);
      } else {
        if (Number(player.playerValue) < Number(playerValue)) {
          player.playerValue = playerValue;
        }
      }
    }
    let arr = Array.from(playerNamesArr);
    return `You successfully invite ${arr.join(', ')}.`;
  }

  signContract(selectedPlayer) {
    let name = selectedPlayer.split('/')[0];
    let playerOffer = Number(selectedPlayer.split('/')[1]);
    if (!this.invitedPlayers.some(x => x.name === name)) {
      throw new Error(`${name} is not invited to the selection list!`)
    }
    let player = this.invitedPlayers.find(x => x.name === name);
    ///// TYK !!!!!!!!!!!!!!!!
    if (Number(playerOffer) < Number(player.playerValue)) {
      throw new Error(`The manager's offer is not enough to sign a contract with ${name}, ${Number(player.playerValue) - Number(playerOffer)} million more are needed to sign the contract!`)
    }

    player.playerValue = `Bought`;

    return `Congratulations! You sign a contract with ${name} for ${playerOffer} million dollars.`
  }

  ageLimit(name, age) {

    if (!this.invitedPlayers.some(x => x.name === name)) {
      throw new Error(`${name} is not invited to the selection list!`)
    }

    let player = this.invitedPlayers.find(x => x.name === name);

    let ageDiffrence = Number(age) - Number(player.age);

    if (ageDiffrence <= 0) {
      return `${name} is above age limit!`
    }

    if (ageDiffrence < 5) {
      return `${name} will sign a contract for ${ageDiffrence} years with ${this.clubName} in ${this.country}!`
    }

    return `${name} will sign a full 5 years contract for ${this.clubName} in ${this.country}!`;

  }

  transferWindowResult() {
    let strings = [];
    strings.push('Players list:');

    this.invitedPlayers.sort((a, b) => a.name.localeCompare(b.name))
      .forEach(x => strings.push(`Player ${x.name}-${x.playerValue}`));

    return strings.join('\n');
  }
}

let fTeam = new footballTeam("Barcelona", "Spain");

console.log(fTeam.newAdditions(["Kylian Mbappé/23/160", "Lionel Messi/35/50", "Pau Torres/25/52"]));

console.log(fTeam.signContract("Kylian Mbappé/240"));

console.log(fTeam.ageLimit("Kylian Mbappé", 30));

console.log(fTeam.transferWindowResult()); 