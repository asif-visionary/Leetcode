class Solution {
    public int maximum69Number(int num) {
        int temp = num;
        int pos = 0;
        int changePos = -1;
        while (temp > 0) {
            if (temp % 10 == 6) {
                changePos = pos; 
            }
            temp /= 10;
            pos++;
        }
        if (changePos != -1) {
            num += 3 * (int)Math.pow(10, changePos);
        }
        return num;
    }
}
