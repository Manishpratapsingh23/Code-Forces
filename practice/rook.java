
import java.util.Scanner;

public class rook {
    public static void main(String agrs[]){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) solve(sc);
    }

    private static void solve(Scanner sc){
        String input = sc.next();
        char y = input.charAt(0);
        int x = (int)(input.charAt(1))-48;
        for(int i=1;i<=8;i++){
            if(i==x) continue;
            System.out.println(y+""+i);
        }
        for(char ch='a';ch<='h';ch++){
            if(y==ch) continue;
            System.out.println(ch+""+x);
        }
    }
}
