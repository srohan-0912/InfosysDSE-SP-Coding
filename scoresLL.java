// You are given a tree with N nodes, where each node has an integer value. 
// You are also given a sequence of N nodes, which represents the order in which the nodes are removed (deforested) from the tree. 
// You must calculate a final score based on the following rules: 1. Initially, add the sum of values of all nodes in the tree to the score. 
// 2. Then, for each node removal: After the removal, if the tree still contains two or more nodes, select any two remaining connected nodes (usually considered the first available pair during traversal) and add the XOR of their values to the score. 
// If only one node remains, add the value of that node to the score. Then, remove the next node based on the given deletion order.
//  3. This process continues until all nodes are removed from the tree. 4. Finally, print the total score. 
// Sample case 1: 1st question input: 3 5 6 7 1 2 3 Output 26
//  N = 3
// Values = 5, 6, 7
// Removal order = 1 2 3
// Output = 26

import java.util.*;
public class scoresLL {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] val=new int[n];
        int[] rem=new int[n];
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
           rem[i]=sc.nextInt();
        }
        int score=0;
        for(int i=0;i<n;i++){
            score+=val[i];
        }
        List<Integer>list=new LinkedList<>();   //or use arrayList
        for(int v:val){
            list.add(v);
        }
        for(int i=0;i<n;i++){
            int remNode=rem[i]-1;    //index starts with 0
            int remVal=val[remNode];

            list.remove((Integer)remVal);   //You must convert the integer to an Integer object so Java removes by value 

            if(list.size() >= 2){
                int a=list.get(0);
                int b=list.get(1);
                score+=(a^b);
            }
            if(list.size() == 1){
               score+=list.get(0);
            }
        }
       System.out.println(score);
    }
}
