class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int negativeCount = 0;
        int minAbsValue = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int num : row) {
                totalSum += Math.abs(num);
                minAbsValue = Math.min(minAbsValue, Math.abs(num));
                if (num < 0) {
                    negativeCount++;
                }
            }
        }
        if (negativeCount % 2 == 0) {
            return totalSum;
        }
        return totalSum - 2 * minAbsValue;
    }
}
