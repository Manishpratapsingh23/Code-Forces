import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmailFromPolycarp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        while(test-- > 0){
            solve(sc);
        }
    }

    private static void solve(Scanner sc){
        List<pair> lst1 = compute(sc.next());
        List<pair> lst2 = compute(sc.next());
        if(lst1.size()!=lst2.size()){
            System.out.println("NO");
            return;
        }
        for(int i=0;i<lst1.size();i++){
            pair p1 = lst1.get(i);
            pair p2 = lst2.get(i);
            if(p1.ch!=p2.ch || p1.size>p2.size){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
       
        
    }

    private static List<pair> compute(String s){
        List<pair> lst = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            int count = 1;
            while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                count++;
                i++;
            }
            pair p = new pair(s.charAt(i),count);
            lst.add(p);
        }
        return lst;
    }

    static class pair{
        char ch;
        int size;
        pair(char ch, int size){
            this.ch = ch;
            this.size = size;
        }
    }

}
