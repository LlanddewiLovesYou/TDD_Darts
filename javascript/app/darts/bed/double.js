const DOUBLE_MULTIPLIER = 2;

class Double {
    constructor(bedValue) {
        this.bedValue = bedValue * DOUBLE_MULTIPLIER;
    }

    bedScore() {
        return this.bedValue;
    }
}

module.exports = Double;