class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] ps = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] = mat[i - 1][j - 1]
                         + ps[i - 1][j]
                         + ps[i][j - 1]
                         - ps[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(m, n), ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (existsSquare(ps, m, n, mid, threshold)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean existsSquare(int[][] ps, int m, int n, int k, int threshold) {
        for (int i = 0; i + k <= m; i++) {
            for (int j = 0; j + k <= n; j++) {
                int sum = ps[i + k][j + k]
                        - ps[i][j + k]
                        - ps[i + k][j]
                        + ps[i][j];
                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}