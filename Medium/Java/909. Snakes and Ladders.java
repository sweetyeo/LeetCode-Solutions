class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0}); 

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int square = curr[0];
            int moves = curr[1];

            if (square == n * n) return moves;

            for (int i = 1; i <= 6 && square + i <= n * n; i++) {
                int next = square + i;
                int[] pos = getCoordinates(next, n);
                int row = pos[0], col = pos[1];

                if (board[row][col] != -1) next = board[row][col];
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, moves + 1});
                }
            }
        }

        return -1;
    }

    private int[] getCoordinates(int square, int n) {
        int quot = (square - 1) / n;
        int row = n - 1 - quot;
        int col = (square - 1) % n;
        if (quot % 2 == 1) col = n - 1 - col;
        return new int[]{row, col};

    }
}
