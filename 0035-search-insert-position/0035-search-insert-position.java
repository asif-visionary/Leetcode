class Solution {
    public int searchInsert(int[] nums, int target) {
        int id = 0;
        for(int i = 0; i < nums.length; i++){
            if(target == nums[i]){
                id = i;
                return id; 
            } else if(target < nums[i]) {
                return i; 
            }
        }
        return nums.length;
    }
}