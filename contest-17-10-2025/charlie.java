import java.util.Scanner;

public class charlie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve(sc);
        }

        sc.close();
    }

    private static void solve(Scanner sc) {
        long a = sc.nextLong();
        long b = sc.nextLong();

        if (a == b) {
            System.out.println(0);
            System.out.println();
            return;
        }

        long diff = a ^ b;

        if (diff <= a) {
            System.out.println(1);
            System.out.println(diff);
            return;
        }

        int highestA = 0, highestB = 0;
        for (int i = 0; i < 60; i++) {
            if (((a >> i) & 1L) == 1L) highestA = i;
            if (((b >> i) & 1L) == 1L) highestB = i;
        }

        if (highestB > highestA) {
            System.out.println(-1);
            return;
        }

        long mask = 0;
        for (int bit = 0; bit <= highestA; bit++) {
            mask |= (1L << bit);
        }

        long result1 = a ^ mask;
        long result2 = mask ^ b;

        System.out.println(2);
        System.out.println(result1 + " " + result2);
    }
}
