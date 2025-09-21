import java.util.Scanner;
public class beta1 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
           
            long result = 0;

            for (int i = 0; i < n; i++) {
                long p1 = sc.nextLong();
                long p2 = sc.nextLong();
                long r1 = sc.nextLong();
                long r2 = sc.nextLong();

                if (p2 > r2) {
                    result += (p1 + p2 - r2);
                } else {
                    result += Math.max(0, p1 - r1);
                }
            }

            System.out.println(result);
            }
    }
}
