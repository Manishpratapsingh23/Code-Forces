import java.util.Scanner;

//import java.util.Scanner;

public class rook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
    }

    private static void solve_kro(Scanner sc) {
        String str = sc.next();
        char col = str.charAt(0);
        char row = str.charAt(1);

        for (char ch = 'a'; ch <= 'h'; ch++) {
            if (ch != col) {
                System.out.println(ch +"" +row);
            }  
        }

        for (char i = '1'; i <= '8'; i++) {
            if (i != row) {
                System.out.println(col +""+ i);
            }
        }
    }
}