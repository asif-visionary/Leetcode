class Solution {
    int dist(int a, int b){
        if(a==26 || b==26) return 0;
        return Math.abs(a/6-b/6) + Math.abs(a%6-b%6);
    }

    public int minimumDistance(String word) {
        int n = word.length();
        int INF = (int)1e9;

        int[] dp = new int[27];
        Arrays.fill(dp, INF);
        dp[26] = 0;

        for(int i=1;i<n;i++){
            int[] next = new int[27];
            Arrays.fill(next, INF);

            int prev = word.charAt(i-1)-'A';
            int cur  = word.charAt(i)-'A';

            for(int j=0;j<=26;j++){
                if(dp[j]==INF) continue;

                next[j] = Math.min(
                    next[j],
                    dp[j] + dist(prev,cur)
                );

                next[prev] = Math.min(
                    next[prev],
                    dp[j] + dist(j,cur)
                );
            }

            dp = next;
        }

        int ans = INF;
        for(int x: dp)
            ans = Math.min(ans, x);

        return ans;
    }
}