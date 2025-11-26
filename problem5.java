// While playing an RPG game, you were assigned to complete one of the hardest quests in this game. 
//There are n monsters you'll need to defeat in this quest. Each monster i is described with two integer numbers - poweri and bonusi. To defeat this monster, you'll need at least poweri experience points.
// If you try fighting this monster without having enough experience points, you lose immediately.
// You will also gain bonusi experience points if you defeat this monster. You can defeat monsters in any order. The quest turned out to be very hard - you try to defeat the monsters but keep losing repeatedly. Your friend told you that this quest is impossible to complete. Knowing that, you're interested, what is the maximum possible number of monsters you can defeat?
// Input: The first line contains an integer, n, denoting the number of monsters. The next line contains an integer, e, denoting your initial experience. Each line i of the n
// subsequent lines (where 0 <= i < n ) contains an integer, poweri, which represents power of the corresponding monster. Each line i of the n subsequent lines (where 0 <= i < n) contains an integer, bonusi, which represents bonus for defeating the corresponding monster.
// 2   -> no of  monster
// 123   ->exp point
// 78    ->power for 1st moster
// 130   ->bonus for 1st monster
// 10     ->power for 2nd master
// 0      ->bonus for 2st monster
//output 2     ->to check how many master defeated return output
import java.util.*;           //not done   imp sum asked in HackWithNfty
public class problem5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int monster=sc.nextInt();
        int exp=sc.nextInt();
        int[] p=new int[monster];
        int[] b=new int[monster];
        for(int i=0;i<monster;i++){
            p[i]=sc.nextInt();
        }
        for(int i=0;i<monster;i++){
            b[i]=sc.nextInt();
        }


    }
}
