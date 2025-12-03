// Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
// Output: 3

public class sample {
    public static void main(String[] args) {
        int W=4;
        int[] val={1,2,3};
        int[] wt={4,5,1};
        int n=val.length;

        int[][] dp=new int[n+1][W+1];
        for(int i=1;i<=n;i++){
            for(int bag=1;bag<=W;bag++){
                if(wt[i-1] <= bag){
                   dp[i][bag]=Math.max(val[i-1]+dp[i-1][bag-wt[i-1]],dp[i-1][bag]);
                }
                else{
                    dp[i][bag]=dp[i-1][bag];
                }
            }
        }
        System.out.println(dp[n][W]);
    }
}
