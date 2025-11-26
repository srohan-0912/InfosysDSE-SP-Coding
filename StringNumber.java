// You are given a string "number" representing a positive integer and a character digit. Return the resulting string after removing exactly one occurrence of digit from number such that the value of the resulting string in decimal form is maximized. The test cases are generated such that digit occurs at least once in the number.
// I/P: number = "1321"
// digit = 1
// O/P: 321
//IP-55125    here digit is '5'
//op-5512

import java.util.Scanner;

class a{
    public static void main(String[] args) {
        // String s="1321";
        // char digit='1';
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String:");
        String s=sc.next();
        System.out.println("Enterr the character:");
        char digit=sc.next().charAt(0);
        System.out.println(greedy(s,digit));
    }
    private static String greedy(String s,char digit){
     int removeInd=-1;
     for(int i=0;i<s.length();i++){
        if(s.charAt(i) == digit){
            removeInd=i;
        
        if(i+1<s.length() && s.charAt(i+1)>digit){
              removeInd=i;
              break;
           }
        }
      }
      return s.substring(0,removeInd)+s.substring(removeInd+1);
    }
}