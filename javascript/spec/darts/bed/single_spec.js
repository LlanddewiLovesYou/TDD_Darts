const Single = require('../../../app/darts/bed/single');

describe('Single', () => {
    describe('.bedScore', () => {
        it('should allow a valid bed value', () => {
            expect(new Single(5).bedScore()).toEqual(5);
        });

        it('it should raise exception when created with bed score just below minimum in range', () => {
            expect(() => { new Single(0) }).toThrowError(RangeError, 'Bed score must be in range 1..20');
        });

        it('it should raise exception when created with bed score just above maximum in range', () => {
            expect(() => { new Single(21) }).toThrowError(RangeError, 'Bed score must be in range 1..20');
        });
    });
});