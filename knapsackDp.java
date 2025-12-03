// 0/1 knapsack wtih memoization using 2D dp

public class knapsackDp {
    static int[] wt={2,4,3,5};
    static int[] pf={3,2,4,3};
    static int n=4;
    static int bagCap=5;
    static int[][] dp=new int[n+1][bagCap+1];

    public static void main(String[] args) {
        System.out.println(knap(n,bagCap));
    }
    public static int knap(int n,int bagCap){
        if(n==0 || bagCap==0){
            return 0;
        }
       if(dp[n][bagCap] !=0){
        return dp[n][bagCap];
       }

        if(wt[n-1]<=bagCap){
         return dp[n][bagCap]=Math.max(pf[n-1]+knap(n-1,bagCap-wt[n-1]),knap(n-1,bagCap));
        }
        else{
            return dp[n][bagCap]=knap(n-1,bagCap);
        }
    }
}
