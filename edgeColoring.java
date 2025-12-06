// Problem Statement

// Given a tree of N nodes and N-1 edges, color each edge such that no two edges incident on the same node share the same color.
// Output the minimum number of colors needed.

// Input Format
// N
// u1 v1
// u2 v2
// ...
// u(N-1) v(N-1)

// Output Format
// minimum_colors
// Sample Input
// 5
// 1 2
// 1 3
// 1 4
// 4 5
// Sample Output
// 3

import java.util.*;
public class edgeColoring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] deg=new int[n+1];
        for(int i=0;i<n-1;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            deg[u]++;
            deg[v]++;
        }
          int maxDeg=0;
        for(int i=1;i<=n;i++){
           if(deg[i]>maxDeg){
            maxDeg=deg[i];
           }
        }
        System.out.println(maxDeg);
    }
}
