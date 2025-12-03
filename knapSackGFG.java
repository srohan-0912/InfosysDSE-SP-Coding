// sol in GFG
import java.util.*;
public class knapSackGFG {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int W=sc.nextInt();
        int n=sc.nextInt();
        int[] wt=new int[n];
        int[] val=new int[n];
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }

       // 0/1 Knapsack DP Table
        int[][] dp = new int[n+1][W+1];

        for(int i = 1; i <= n; i++){
            for(int bag = 1; bag <= W; bag++){
                
                if(wt[i-1] <= bag){
                    dp[i][bag] = Math.max(val[i-1] + dp[i-1][bag - wt[i-1]],
                                          dp[i-1][bag]);
                } else {
                    dp[i][bag] = dp[i-1][bag];
                }
            }
        }

        // Final Output
        System.out.println("\nMaximum Value Achievable = " + dp[n][W]);
    }
}
