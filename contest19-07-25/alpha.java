import java.util.Scanner;
public class alpha {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
        int row_row_row = sc.nextInt();
            int col_col_col = sc.nextInt();
            boolean x = Math.min(row_row_row, col_col_col) >=2;
            boolean y =  Math.max(row_row_row, col_col_col) >= 3;
            if (x && y) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
     }
}
