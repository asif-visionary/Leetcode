class Solution {
    public int alternatingSum(int[] nums) {
        int sign = 1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += (sign) * nums[i];
            sign *= -1;
        }
        return result;
    }
}