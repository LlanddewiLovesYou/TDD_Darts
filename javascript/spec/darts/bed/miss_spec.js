const Miss = require('../../../app/darts/bed/miss');

describe('Miss', () => {
    describe('.bedScore', () => {
        it('is zero points', () => {
            expect(new Miss().bedScore()).toEqual(0);
        });
    });
});