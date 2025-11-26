//QSPIDER 
//You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:
// "1" -> 'A'
// "2" -> 'B'
// "25" -> "Y"
// "26" -> 'Z'
// However, while decoding the message, you realize that there are many different ways you can decode the message

// Example 1:
// Input: s = "12"
// Output: 2
// Explanation:
// "12" could be decoded as "AB" (1 2) or "L" (12).
// Example 2:
// Input: s = "226"
// Output: 3
// Explanation:
// "226" could be decoded as "BZ" (226), "VF" (22 6), or "BBF" (2 2 6).
// Example 3:
// Input: s = "06"
// Output: 0
// Explanation:
// "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06"). In this case, the string is not a valid encoding, so return 0.

import java.util.*;
public class decodeStringQS {
    public static void main(String[] args) {
        // String s="11105";
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(decode(s));
    }
    public static int decode(String s){
        int n=s.length();
        if(s.length() == 0 || s==null )  return 1;
        if(s.charAt(0) == '0')  return 0;
        
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            int oneDigit=Integer.parseInt(s.substring(i-1,i));
            int twoDigit=Integer.parseInt(s.substring(i-2,i));
          
            if(oneDigit>=1 && oneDigit<=9){
                dp[i]+=dp[i-1];
            }
            if(twoDigit>=10 && twoDigit <=26 ){
                dp[i]+=dp[i-2];
            }
        }
        return dp[n];
    }
}
