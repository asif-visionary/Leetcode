class Solution {
    public int minElement(int[] nums) {
            int min = Integer.MAX_VALUE;

    for (int n : nums) {
        int sum = 0;
        int temp = n;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        min = Math.min(min, sum);
    }

    return min;
    }
}