/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    const isNegative = x < 0;
    let reversed = 0;
    x = Math.abs(x);

    while (x !== 0) {
        const digit = x % 10;
        x = Math.floor(x / 10);

        // Check for overflow before it happens
        if (reversed > Math.floor((2**31 - 1) / 10)) return 0;

        reversed = reversed * 10 + digit;
    }

    return isNegative ? -reversed : reversed    
};
