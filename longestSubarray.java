// Questionn no 10 :

// You are given an array A of size n, initially filled with zeros.

// You will be given q operations.
// Each operation has the format:

// l r x y

// For each operation, you must assign values to the subarray A[l..r] in the form of an arithmetic sequence:
// A[l]     = x
// A[l+1]   = x + y
// A[l+2]   = x + 2y
// ...
// A[r]     = x + (r - l)*y

// After performing all operations, determine the length of the longest contiguous arithmetic subarray in the final array.
// 📥 Input Format
// n q
// l1 r1 x1 y1
// l2 r2 x2 y2
// ...
// lq rq xq yq

// 📤 Output Format

// Print a single integer — the length of the longest contiguous arithmetic subarray after all operations.

// 📌 Sample Input
// 10 --> size of array
// 3   ----> no of operation(q)
// 1 6 2 2
// 4 9 20 -3
// 2 5 10 0

// output :- 4
import java.util.*;
public class longestSubarray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        int[] arr=new int[n+1];

          while(q-- >0){
           int l=sc.nextInt();
           int r=sc.nextInt();
           int x=sc.nextInt();
           int y=sc.nextInt();

           for(int i=l;i<=r;i++){
            arr[i]=x+(i-l)*y;
           }  
        }
        int res=longest(n,arr);
        System.out.println(res);
    }
    private static int longest(int n,int[] arr){
        if(n<2)   return n;

        int longSub=2;
        int curr=2;
        int diff=arr[1]-arr[0];
        for(int i=2;i<=n;i++){
            if(arr[i] - arr[i-1] == diff){
                curr++;
            }
            else{
                diff=arr[i]-arr[i-1];
                 curr=2;
            }
            longSub=Math.max(longSub,curr);
        }
       return longSub;
    }
}
