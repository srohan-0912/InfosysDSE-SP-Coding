// Maximum Sum of Good Subarray
// Full Question:
// You are given an array A of length N and an integer k.  It is given that a subarray from l to r is
// considered good, if the number of distinct elements in that subarray doesn't exceed k. 
// Additionally, an empty subarray is also a good subarray and its sum is considered to be zero. 
// Find the maximum sum of a good subarray. 49
// Sample Input 1:
// N = 11 
// k = 2 
// A = [1, 2, 2, 3, 2, 3, 5, 1, 2, 1, 1] 
// Sample Output 1:
// 12 

import java.util.*;
public class maxGoodSubarray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] A=new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        System.out.println(maxArray(A,k));
    }
    public static int maxArray(int[] A,int k){
     int maxSum=0;
     int currSum=0;
     int left=0;
    HashMap<Integer,Integer> map=new HashMap<>();
     for(int right=0;right<A.length;right++){
       map.put(A[right],map.getOrDefault(A[right],0)+1);
       currSum+=A[right];
    
     while(map.size() > k){
       map.put(A[left],map.get(A[left])-1);
       currSum-=A[left];
       
       if(map.get(A[left]) == 0){
          map.remove(A[left]);
       }
        left++;
      } 
      maxSum=Math.max(maxSum,currSum);
     }
      return maxSum;
    }
}
