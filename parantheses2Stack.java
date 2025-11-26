// input1:-  (){ }[ ]
// 4
// 1 4
// 2 3
// 3 6
// 1 6
//output:- 2
// input 2:-  ([{}])
// 5
// 1 6
// 1 2
// 2 5
// 3 4
// 1 3
// output:-3

import java.util.*;
public class parantheses2Stack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();  
        s=s.replace(" ","");
        int n=sc.nextInt();
        int cnt=0;
        for(int i=0;i<n;i++){
          int l=sc.nextInt();
          int r=sc.nextInt();
          
        
          String subString=s.substring(l-1,r);
         
          if(isBalanced(subString)){
            cnt++;
          }
        }
       System.out.println(cnt);

    }
    private static boolean isBalanced(String s){
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
           if(c=='(' || c=='{' || c=='['){
            st.push(c);
           }
           else{
                  if(st.isEmpty())  {
                      return false;
                    }
                    char top=st.pop();
                    if(c==')'&&top!='(' || c==']'&&top!='[' || c=='}'&&top!='{'){
                        return false;
                    }

           }
        }
        return st.isEmpty();
    }
}
