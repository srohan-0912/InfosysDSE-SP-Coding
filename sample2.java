 import java.util.*;
public class sample2 {

   static final long MOD = 1000000007L;
    static List<Integer>[] tree;
    static long[] beauty;
    static int[] core;

 static int getSqr(int x){
        int res=1;
        for(int i=2;i*i<=x;i++){
            if(x%i ==0){
                int cnt=0;
                while(x%i == 0){
                    x/=i;
                    cnt++;
                }
                if(cnt%2 == 1) res*=i;
            }
        }
       if(x>1) res*=x;  //Either a prime number or a product of primes larger than √
       return res;
    }
    static HashMap<Integer,Integer> dfs(int u){
        HashMap<Integer,Integer> freq=new HashMap<>();
        freq.put(core[u],1);
        
        for(int child:tree[u]){
            HashMap<Integer,Integer> childMap=dfs(child);
        // Add Childs beauty to parent beauty
        beauty[u]+=beauty[child];

        //swap map if the child map is larger
        if(childMap.size() > freq.size()){
              HashMap<Integer,Integer> temp=freq;
              freq=childMap;
              childMap=temp;
        }
         //count good pairs
         for(Map.Entry<Integer,Integer> entry:childMap.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();

            if(freq.containsKey(key)){
                beauty[u]+=(long) freq.get(key)*val;
            }
         }
         //Merge map(add frequencies)
         for(Map.Entry<Integer,Integer> entry:childMap.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();
            freq.put(key,freq.getOrDefault(key,0)+val);
         }
        }
        return freq;
    }
    static long getAns(int n,int[] par,int[] a){
        tree=new List[n+1];
        beauty=new long[n+1];
        core=new int[n+1];
        
        for(int i=0;i<=n;i++) tree[i]=new ArrayList<>();

        for(int i=2;i<=n;i++){
            tree[par[i]].add(i);
        }

        for(int i=1;i<=n;i++){
            core[i]=getSqr(a[i]);
        }
        dfs(1);
        long sum=0;
        for(int i=1;i<=n;i++){
            sum=(sum+beauty[i]) % MOD;
        }
      return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] par=new int[n+1];
        for(int i=1;i<=n;i++){
            par[i]=sc.nextInt();
        }
        int[] a=new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println(getAns(n,par,a));
    }
}
    
