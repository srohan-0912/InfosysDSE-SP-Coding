
// Interval Problem (Maximum Non-Overlapping Intervals)
// Problem Statement
// Given N intervals [start_i, end_i], find the maximum number of non-overlapping intervals that can be selected.
// Input Format
// N
// start_1 end_1
// start_2 end_2
// ...
// start_N end_N
// Output Format
// max_non_overlapping_intervals
// Sample Input
// 4
// 1 3
// 2 5
// 4 6
// 6 7

// Sample Output
// 3
import java.util.*;
public class maximumNonOverlaping {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] interval=new int[n][2];
        for(int i=0;i<n;i++){
            interval[i][0]=sc.nextInt();
            interval[i][1]=sc.nextInt();
        }
        Arrays.sort(interval,(a,b)->a[1]-b[1]);   //make sec value in asc order

        int cnt=0;
        int lastVal=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(interval[i][0] >= lastVal){
                cnt++;
                lastVal=interval[i][1];
            }
        }
        System.out.println(cnt);
    }
}
