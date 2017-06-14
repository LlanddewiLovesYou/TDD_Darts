const Triple = require('../../../app/darts/bed/triple');

describe('Triple', () => {
    describe('.bedScore', () => {
        it('should triple a valid bed score', () => {
            expect(new Triple(5).bedScore()).toEqual(15);
        });

        it('should raise exception when created with bed score just below minimum in range', () => {
            expect(() => { new Triple(0) }).toThrowError(RangeError, 'Bed score must be in range 1..20');
        });
    });
});