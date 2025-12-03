//Q1 — “Lucky Leaf Sum” (Tree + BFS Filtering) 
// You're given a tree of N nodes.
// Each node contains a value.
// Two players: Alice and Bob start at nodes A and B.
// A node x is considered Lucky if:
// distance(A → x) < distance(B → x)
// Your task:
//Collect the sum of all leaf nodes that are Lucky (leaf = degree 1 and not root unless
// N=1).

// Input Format
// N
// values[1..N]
// edges (N−1 lines)
// A B

// 긱긲긳긴 Output
// Sum of lucky leaf nodes

//  Example
// Input:
// 5
// 3 8 2 5 10
// 1 2
// 1 3
// 2 4
// 3 5
// 2 3

// Output:
// 15
// (Tree leaves: 4 and 5 → both are lucky → 5 + 10 = 15)

import java.util.*;

public class luckLeaf {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt(); 
       int[] val=new int[n+1];
       for(int i=1;i<=n;i++){
        val[i]=sc.nextInt();
       }
   // Adjacency list representation of tree (graph)
       List<List<Integer>> graph=new ArrayList<>();
       for(int i=0;i<=n;i++){
        graph.add(new ArrayList<>());
       }

       int[] deg=new int[n+1];
       for(int i=0;i<n-1;i++){
        int u=sc.nextInt();
        int v=sc.nextInt();
        graph.get(u).add(v);   // undirected graph
        graph.get(v).add(u);
        deg[u]++;         // count degree of each node
        deg[v]++;
       }
       int A=sc.nextInt();
       int B=sc.nextInt();

        // BFS from Alice → stores distance of every node from A
       int[] disA=bfs(A,graph,n);
      // BFS from Bob → stores distance of every node from B
       int[] disB=bfs(B,graph,n);

       int sum=0;
       for(int i=1;i<=n;i++){
        if(deg[i] == 1){
     if(disA[i] < disB[i]){   //if(disA[i] != -1){  -> to get 15 as output
                sum+=val[i];
            }
        }
       }
       System.out.println(sum);
    }
    private static int[] bfs(int st,List<List<Integer>> graph,int n){
        int[] dis=new int[n+1];
        Arrays.fill(dis,-1);
        Queue<Integer> q=new LinkedList<>();
        dis[st]=0;     // Starting node always distance 0
        q.add(st);    // Push start node into queue

        while(!q.isEmpty()){
            int node=q.poll();
            for(int i:graph.get(node)){
               if(dis[i] == -1){
                   dis[i]=dis[node]+1;
                   q.add(i);
               }
            }
        }
        return dis;
    }
}
