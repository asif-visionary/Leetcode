class Solution {
    public int[] transformArray(int[] nums) {
        int[] n = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                n[i] = 0;
            } else {
                n[i] = 1;
            }
        }
         Arrays.sort(n);
        return n;
    }
}
