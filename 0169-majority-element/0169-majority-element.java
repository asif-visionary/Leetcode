class Solution {
    public int majorityElement(int[] nums) {
       int res = 0, freq = 0;
       for(int num : nums){
        if(freq ==0) res = num;
        freq+=num == res?1:-1;
       }
       return res;
    }
}