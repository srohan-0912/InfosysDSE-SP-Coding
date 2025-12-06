// You are given two arrays. Transform array 1 into array 2 using the minimum number of swaps. 
// You are allowed to swap only adjacent elements. Find the minimum swaps required and return the swap count. 
// generate a input and output format.
// Example 1
// Input:
// 5
// 1 3 2 4 5
// 1 2 3 4 5

// Output:
// 1
// Explanation:
// Swap 3 and 2 → 1 2 3 4 5

// Example 2
// Input:

// 4
// 1 2 3 4
// 1 3 2 5

// Output:
// -1
// Explanation:
// Arrays have different elements, so transformation is impossible
import java.util.*;
public class adjacentSwap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];

        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i]=sc.nextInt();
        }
      System.out.println(swap(a,b));
    }
    static int swap(int[] a,int[] b){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:a){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:b){
            if(!map.containsKey(i))  {
                return -1;
            }
            map.put(i,map.get(i)-1);
            if(map.get(i) == 0){
                map.remove(i);
            }
        }
     int swap=0;
     int i=a.length-1;
     int j=b.length-1;
     while(i>=0){
        if(a[i] == b[i]){
            i--;
            j--;
        }
        else{
            // Swap A[i-1] with A[i] until A[i] matches B[j]
            int k=i;
            while(k>=0 && a[k] != b[j]){
                k--;
            }
            if(k<0){
                return -1;
            }
            while(k<i){
                   // swap adjacent elements
                   int temp=a[k];
                   a[k]=a[k+1];
                   a[k+1]=temp;
                   swap++;
                   k++;
            }
          i--;
          j--;
        }
     }
     return swap;
    }
}
