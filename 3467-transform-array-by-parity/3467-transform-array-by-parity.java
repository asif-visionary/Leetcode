class Solution {
    public int[] transformArray(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[index++] = 0;
            }
        }
        while (index < nums.length) {
            res[index++] = 1;
        }
        return res;
    }
}
