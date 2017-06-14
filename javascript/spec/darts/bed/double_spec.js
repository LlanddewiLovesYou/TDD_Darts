const Double = require('../../../app/darts/bed/double');

describe('Double', () => {
    describe('.bedScore', () => {
        it('should double a valid bed score', () => {
            expect(new Double(10).bedScore()).toEqual(20);
        });
    });
});
