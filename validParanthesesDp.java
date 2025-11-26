// Number of Valid Parentheses Expressions

// Given an integer n, find the number of valid parentheses expressions of length n.
// Examples : 
// Input: n = 2
// Output: 1 
// Explanation: There is only one possible valid expression of length 2, "()"

// Input: n = 4
// Output: 2 
// Explanation: Possible valid expression of length 4 are "(())" and "()()" 

// Input: n = 6
// Output: 5
// Explanation: Possible valid expressions are "((()))", "()(())", "()()()", "(())()" and "(()())"



public class validParanthesesDp {
    public static void main(String[] args) {
        int n=6;
        System.out.println(para(n));
    }
    public static int para(int n){
        if(n%2!=0){
            return 0;
        }
        int k=n/2;
        long[] dp=new long[k+1];
        dp[0]=1;
        for(int i=1;i<=k;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }
     return (int)dp[k];
    }
}
