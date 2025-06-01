class Solution {
    public long distributeCandies(int n, int limit) {
        return comb(n)
             - 3 * comb(n - (limit + 1))
             + 3 * comb(n - 2 * (limit + 1))
             - comb(n - 3 * (limit + 1));
    }

    private long comb(int x) {
        if (x < 0) return 0;
        return (long)(x + 2) * (x + 1) / 2;
    }
}
