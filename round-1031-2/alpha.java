import java.util.Scanner;

public class alpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int node = sc.nextInt();
            int exact = sc.nextInt();
            for (int i = 0; i < exact; i++)             System.out.print(1);
            for (int i = exact; i < node; i++)      System.out.print(0);
            System.out.println();
        }
    }
}
