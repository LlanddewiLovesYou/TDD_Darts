const Single = require('../../../app/darts/bed/single');

describe('Single', () => {
    describe('.bedScore', () => {
        it('should allow a valid bed value', () => {
            expect(new Single(5).bedScore()).toEqual(5);
        });
    });
});