class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int target = nums.get(i);
            int answer = -1; // default if impossible
            int bitmask = 1; // starts from the least significant bit

            // Try removing trailing 1-bits
            while ((target & bitmask) != 0) {
                answer = target - bitmask; // turn off this bit
                bitmask <<= 1; // move to next bit
            }
            result[i] = answer;
        }
        return result;
    }
}
