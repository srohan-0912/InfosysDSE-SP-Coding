// You have a array you need to perform the given task:
// 1. If the array length is greater than 1 then take any two numbers which are X != Y and remove X and Y 
// 
// 2. Else take X and remove X
// Count the minimum number of step to remove all element from list.
// I/P: 1,2
// O/P: 1
// I/P: 2,2
// O/P: 2
// I/P: 2,2,3,3,1
// O/P: 3     => (2,3)(2,3)(1)

import java.util.*;
public class problem4 {
    public static void main(String[] args) {
        int[] arr={2,2};
        List<Integer> list =new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        int cnt=0;
        Collections.sort(list);
        while(!list.isEmpty()){
           if(!list.get(0).equals(list.get(list.size()-1))){
               list.remove(list.size()-1);
               if(!list.isEmpty()){
                list.remove(0);
                cnt++;
               }
           }
           else{
            list.remove(0);
            cnt++;
           }
        }
        
        System.out.println(cnt);
    }
}
