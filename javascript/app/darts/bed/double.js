const DOUBLE_MULTIPLIER = 2;

class Double {
    constructor(bedValue) {
        if (bedValue < 1) {
            throw new RangeError('Bed score must be in range 1..20');
        }
        this.bedValue = bedValue * DOUBLE_MULTIPLIER;
    }

    bedScore() {
        return this.bedValue;
    }
}

module.exports = Double;