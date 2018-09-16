class Player {
  constructor() {
    this.points = 501;
  }

  score() {
    return this.points;
  }

  turn(...throws) {
    const turn = [...throws];
    let turnScore = 0;
    turn.forEach(dart => {
      turnScore = turnScore + dart.bedScore();
    });
    if (this.score() - turnScore > 0) {
      this.points = this.points - turnScore;
    }
  }
}

module.exports = Player;
