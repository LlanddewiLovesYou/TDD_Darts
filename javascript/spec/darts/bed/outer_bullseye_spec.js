const OuterBullseye = require('../../../app/darts/bed/outer_bullseye');

describe('OuterBullseye', () => {
    describe('.bedScore', () => {
        it('is 25 points', () => {
            expect(new OuterBullseye().bedScore()).toEqual(25);
        });
    });
});