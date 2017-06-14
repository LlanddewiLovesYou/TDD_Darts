const Pass = require('../../../app/darts/bed/pass');

describe('Pass', () => {
    describe('.bedScore', () => {
        it('is zero points', () => {
            expect(new Pass().bedScore()).toEqual(0);
        });
    });
});
