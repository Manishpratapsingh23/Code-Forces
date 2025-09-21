import java.util.Scanner;

public class charlie1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            solve(n, k);
        }
    }

    private static void solve(long n, long k) {
        long cost = 0;
        long dealsNeeded = 0;
        int x = 0;

        while (n > 0) {
            int d = (int)(n % 3);
            if (d > 0) {
                long dealCost = pow3(x + 1) + (x == 0 ? 0 : x * pow3(x - 1));
                cost += d * dealCost;
                dealsNeeded += d;
            }
            n /= 3;
            x++;
        }

        if (dealsNeeded > k) {
            System.out.println(-1);
        } else {
            System.out.println(cost);
        }
    }

    private static long pow3(int exp) {
        long res = 1;
        for (int i = 0; i < exp; i++) res *= 3;
        return res;
    }
}
