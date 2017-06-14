const Double = require('../../../app/darts/bed/double');

describe('Double', () => {
    describe('.bedScore', () => {
        it('should double a valid bed score', () => {
            expect(new Double(10).bedScore()).toEqual(20);
        });

        it('should raise exception when created with bed score just below minimum in range', () => {
            expect(() => { new Double(0) }).toThrowError(RangeError, 'Bed score must be in range 1..20');
        });
    });
});
