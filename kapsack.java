//  0/1 knapsack using recurssion


public class kapsack {
     static int[] wt={2,4,3,5};
    static int[] pf={3,2,4,3};
    public static void main(String[] args) {
        System.out.println(knap(4,5));
    }
    public static int knap(int n,int bagCap){
        if(n==0 || bagCap==0){
            return 0;
        }
        if(wt[n-1]<=bagCap){
         return Math.max(pf[n-1]+knap(n-1,bagCap-wt[n-1]),knap(n-1,bagCap));
        }
        else{
            return knap(n-1,bagCap);
        }
    }
}

