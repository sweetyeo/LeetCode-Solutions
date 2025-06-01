/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
        if (numRows === 1 || s.length <= numRows) return s;

    const rows = Array.from({ length: numRows }, () => "");

    let currRow = 0;
    let goingDown = false;

    for (let char of s) {
        rows[currRow] += char;
        if (currRow === 0 || currRow === numRows - 1) goingDown = !goingDown;
        currRow += goingDown ? 1 : -1;
    }

    return rows.join('')
};
