// You are given an integer n. A 0-indexed integer array nums of length n + 1 is generated following the rules:
// 1. nums[0]=0
// 2. nums[1]=1
// 3. nums[2*i] = nums[i], when 2<= 2*i <= n
// 4. nums[2*i+1] = nums[i] + nums[i+1], when 2<=2^ * i + 1 <= n
// Return the maximum integer in the array nums.


// For n = 7 → 
// nums =[0, 1, 1, 2, 1, 3, 2, 3]
// Max = 3

import java.util.*;
public class problem2 {
    public static void main(String[] args) {
        int n=7;
        int[] arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n/2;i++){
           if(i*2<=n){
               arr[2*i]=arr[i];
               max=Math.max(max,arr[2*i]);
           }
           if(i*2+1<=n){
            arr[2*i+1]=arr[i]+arr[i+1];
             max=Math.max(max,arr[2*i+1]);
           }
        }
        System.out.println(max);
    }
}
