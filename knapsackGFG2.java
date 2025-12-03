//  Optimized Recursive + Memoization Solution
public class knapsackGFG2 {
    static int[][] dp ;     // make dp global so recursion can access it
   public static void main(String[] args) {
    int W = 4; 
    int[] val = {1, 2, 3}; 
    int[] wt = {4, 5, 1}; 
    int n = val.length;
     dp = new int[n+1][W+1]; 
    
    // initialize dp with -1 (uncomputed states)
    for(int i=0;i<=n;i++){ 
    for(int j=0;j<=W;j++){
         dp[i][j] = -1;
         }  
    } 
    System.out.println("Maximum Value = " + knapsack(W, val, wt, n));
   }

   public static int knapsack(int W,int[] val,int[] wt,int n){
    if(n == 0 || W ==0){
        return 0;
    }
    if(dp[n][W] != -1){    // Return stored value (no recalculation)
        return dp[n][W];
    }

    //  If item is heavier than current capacity → skip
    if(wt[n-1]>W){
       return dp[n][W]= knapsack(W,val,wt,n-1);
    }
    //// OPTION 1: Take item
    int take=val[n-1]+knapsack(W-wt[n-1],val,wt,n-1);
    //// OPTION 2: Skip item
    int skip=knapsack(W,val,wt,n-1);

    return Math.max(take,skip);
   } 
}
