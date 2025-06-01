/**
 * @param {number} n
 * @param {number} limit
 * @return {number}
 */
var distributeCandies = function(n, limit) {
        const comb = (x) => (x < 0 ? 0 : ((x + 2) * (x + 1)) / 2);

    let total = comb(n);

    total -= 3 * comb(n - (limit + 1));

    total += 3 * comb(n - 2 * (limit + 1));

    total -= comb(n - 3 * (limit + 1));

    return total;
};
