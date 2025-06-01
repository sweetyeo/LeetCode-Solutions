/**
 * @param {number[][]} board
 * @return {number}
 */
var snakesAndLadders = function(board) {
    const n = board.length;
    const visited = new Array(n * n + 1).fill(false);
    const queue = [[1, 0]];

    function getCoordinates(square) {
        const quot = Math.floor((square - 1) / n);
        let row = n - 1 - quot;
        let col = (square - 1) % n;
        if (quot % 2 === 1) col = n - 1 - col;
        return [row, col];
    }

    while (queue.length > 0) {
        const [square, moves] = queue.shift();

        if (square === n * n) return moves;
        for (let i = 1; i <= 6; i++) {
            let next = square + i;
            if (next > n * n) continue;
            const [r, c] = getCoordinates(next);
            if (board[r][c] !== -1) next = board[r][c];

            if (!visited[next]) {
                visited[next] = true;
                queue.push([next, moves + 1]);
            }
        }
    }

    return -1; 
};
