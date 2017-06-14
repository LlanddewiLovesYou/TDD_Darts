class Single {
    constructor(bedValue) {
        if (bedValue < 1) {
            throw new RangeError('Bed score must be in range 1..20');
        }
        this.bedValue = bedValue;
    }

    bedScore() {
        return this.bedValue;
    }
}

module.exports = Single;