const Triple = require('../../../app/darts/bed/triple');

describe('Triple', () => {
    describe('.bedScore', () => {
        it('should triple a valid bed score', () => {
            expect(new Triple(5).bedScore()).toEqual(15);
        });
    });
});