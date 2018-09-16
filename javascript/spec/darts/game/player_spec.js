const Player = require("../../../app/darts/game/player");
const InnerBullseye = require("../../../app/darts/bed/inner_bullseye");

describe("Player", () => {
  describe("#score", () => {
    it("sets Player.score correctly", () => {
      const player1 = new Player();
      expect(player1.score()).toEqual(501);
    });
  });

  describe("#turn", () => {
    it("subtracts the correct amount from the score on a given turn", () => {
      const player1 = new Player();
      const bullseye = new InnerBullseye();
      player1.turn(bullseye, bullseye, bullseye);
      expect(player1.score()).toEqual(501 - 150);
    });

    it("resets the player's score if a throw brings the score to below zero", () => {
      const player1 = new Player();
      player1.points = 100;
      const bullseye = new InnerBullseye();
      player1.turn(bullseye, bullseye, bullseye);
      expect(player1.score()).toEqual(100);
    });
  });
});
