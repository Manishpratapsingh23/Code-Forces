import java.util.Scanner;

public class charlie {
    public static void solve(int cs, Scanner sc) {
        long n = sc.nextInt();
        long l = sc.nextInt();
        long r = sc.nextInt();
        long k = sc.nextInt();

        if (n % 2 == 1) {
            System.out.println("1");
            return;
        }

        long pw = 1;
        long got = -1;

        while ((pw * 2) <= r) {
            pw *= 2;
            if (l < pw && pw <= r) {
                got = pw;
                break;
            }
        }

        if (got == -1 || n == 2) {
            System.out.println("-1");
        } else if (k < n - 2) {
            System.out.println("1");
        } else {
            System.out.println(pw);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cs = 1; cs <= t; cs++) {
            solve(cs, sc);
        }
    }
}
