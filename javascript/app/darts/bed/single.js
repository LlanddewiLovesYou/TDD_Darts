class Single {
    constructor(bedValue) {
        if (bedValue < 1) {
            throw new RangeError('Bed score must be in range 1..20');
        }
    }

    bedScore() {
        return 5;
    }
}

module.exports = Single;