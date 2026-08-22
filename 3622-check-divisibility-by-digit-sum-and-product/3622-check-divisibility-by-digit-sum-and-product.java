class Solution {
    public boolean checkDivisibility(int n) {
        int s = 0;
        int f = 1;
        int t = n;

        while (t != 0) {
            int r = t % 10;
            s += r;
            f *= r;
            t /= 10;
        }
       return n % (s + f) == 0;
    }
}