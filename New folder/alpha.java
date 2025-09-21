import java.util.Scanner;

public class alpha {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int a = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(a<x && a<y) System.out.println("Yes");
            else if(a>x && a>y) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}