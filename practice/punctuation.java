
import java.util.Scanner;

public class punctuation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solve_kro(sc);
    }

    private static void solve_kro(Scanner sc){
        String s = sc.nextLine();
        s.trim();
        StringBuilder sb = new StringBuilder();
        int space = 0;
        boolean canAdd = false;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                if(space>0 && canAdd) sb.append(' ');
                sb.append(ch);
                canAdd = true;
                space = 0;
            }
            else if(ch==' ') space++;
            else{
                sb.append(ch);
                sb.append(' ');
                space = 0;
                canAdd = false;
            }
        }
        //System.out.println(sb.toString().length());
        System.out.println(sb.toString());
    }
}
