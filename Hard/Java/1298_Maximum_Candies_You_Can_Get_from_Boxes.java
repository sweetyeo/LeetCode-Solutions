class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] haveKey = new boolean[n];
        boolean[] haveBox = new boolean[n];
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int box : initialBoxes) {
            haveBox[box] = true;
            if (status[box] == 1) {
                queue.offer(box);
                visited[box] = true;
            }
        }

        int totalCandies = 0;

        while (!queue.isEmpty()) {
            int box = queue.poll();
            totalCandies += candies[box];

            for (int key : keys[box]) {
                if (!haveKey[key]) {
                    haveKey[key] = true;
                    if (haveBox[key] && !visited[key] && status[key] == 0) {
                        status[key] = 1;
                        queue.offer(key);
                        visited[key] = true;
                    }
                }
            }

            for (int contained : containedBoxes[box]) {
                if (!haveBox[contained]) {
                    haveBox[contained] = true;
                }
                if ((status[contained] == 1 || haveKey[contained]) && !visited[contained]) {
                    if (status[contained] == 0 && haveKey[contained]) {
                        status[contained] = 1;
                    }
                    queue.offer(contained);
                    visited[contained] = true;
                }
            }
        }

        return totalCandies;
    }
}
