// Problem Statement
// Given an array of integers and a target sum K, find the length of the longest contiguous subarray whose elements sum up exactly to K.
// If no such subarray exists, print 0.
// Input Format
// N
// a1 a2 a3 ... aN
// K
// Where:
// N → number of elements
// a1 … aN → integers in the array
// K → target sum
// Output Format
// <length of the longest subarray>
// ✅ Sample Input
// 8
// 1 2 3 1 1 1 1 5
// 6

// ✅ Sample Output
// 4

//LATEST INFOSYS QNES
import java.util.*;
public class maximumsubstring {
 public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] a=new int[n];
    for(int i=0;i<n;i++){
      a[i]=sc.nextInt();
    }
    int k=sc.nextInt();

    int res=substring(a,k);
    System.out.println(res);
 }   
 static int substring(int[] a,int k){
    int preSum=0;
    int maxLen=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<a.length;i++){
      preSum+=a[i];
      if(preSum == k){
        maxLen=i+1;
      }
      if(map.containsKey(preSum-k)){
        int len=i-map.get(preSum-k);
        maxLen=Math.max(len,maxLen);
      }
      map.putIfAbsent(preSum, i);
    }
    return maxLen;
 }
}
