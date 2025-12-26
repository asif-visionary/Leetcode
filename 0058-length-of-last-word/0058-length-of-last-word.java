import java.util.StringTokenizer;
class Solution {
    public int lengthOfLastWord(String s) {
        int n =0;
        StringTokenizer st = new StringTokenizer(s," ");
        while(st.hasMoreTokens()){
            String p = st.nextToken();
            n= p.length();
        }
        return n;
    }
}