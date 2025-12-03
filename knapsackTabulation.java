//Using Tabulation Method

public class knapsackTabulation {
    static int[] wt = {2, 4, 3, 5};
    static int[] pf = {3, 2, 4, 3};
    static int n = wt.length;
    static int bagCap = 5;

    public static void main(String[] args) {
        System.out.println(knap(bagCap));
    }

    public static int knap(int bagCap) {
        int[][] dp = new int[n + 1][bagCap + 1];

        // dp[i][j] = max profit using i items with capacity j

        for (int i = 1; i <= n; i++) {
            for (int cap = 1; cap <= bagCap; cap++) {

                if (wt[i - 1] <= cap) {
                    // Include or exclude the item
                    dp[i][cap] = Math.max(
                        pf[i - 1] + dp[i - 1][cap - wt[i - 1]],
                        dp[i - 1][cap]
                    );
                } else {
                    // Cannot include item (too heavy)
                    dp[i][cap] = dp[i - 1][cap];
                }
            }
        }

        return dp[n][bagCap]; // final result
    }
}

