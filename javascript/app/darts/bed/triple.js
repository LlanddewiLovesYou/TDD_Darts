const MULTIPLIER = 3;

class Triple {
    constructor(bedValue) {
        this.bedValue = bedValue * MULTIPLIER;
    }

    bedScore() {
        return this.bedValue;
    }
}

module.exports = Triple;