const MULTIPLIER = 3;

class Triple {
    constructor(bedValue) {
        if (bedValue < 1) {
            throw new RangeError('Bed score must be in range 1..20');
        }
        this.bedValue = bedValue * MULTIPLIER;
    }

    bedScore() {
        return this.bedValue;
    }
}

module.exports = Triple;