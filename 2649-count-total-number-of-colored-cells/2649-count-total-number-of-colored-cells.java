class Solution {
    private long calculate1toNTotal(long n) {
        return (n * (n + 1)) / 2;
    }

    public long coloredCells(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 5;
        return calculate1toNTotal((long)n) + calculate1toNTotal((long)n - 1) 
        + calculate1toNTotal((long)n - 1) + calculate1toNTotal((long)n - 2); 
    }
}