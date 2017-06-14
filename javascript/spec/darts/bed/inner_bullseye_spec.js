const InnerBullseye = require('../../../app/darts/bed/inner_bullseye');

describe('InnerBullseye', () => {
    describe('.bedScore', () => {
        it('is 50 points', () => {
            expect(new InnerBullseye().bedScore()).toEqual(50);
        });
    });
});