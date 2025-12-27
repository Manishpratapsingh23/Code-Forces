import java.util.Scanner;

public class beta {
    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int mn = 1, mx = 1;

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            if (a[i] < a[mn]) mn = i;
            if (a[i] > a[mx]) mx = i;
        }

        String t = sc.next();
        t = " " + t;

        if (t.charAt(1) == '1' || t.charAt(n) == '1') {
            System.out.println(-1);
            return;
        }
        if (t.charAt(mn) == '1' || t.charAt(mx) == '1') {
            System.out.println(-1);
            return;
        }

        System.out.println(5);
        System.out.println("1 " + mn);
        System.out.println("1 " + mx);
        System.out.println(mn + " " + n);
        System.out.println(mx + " " + n);
        System.out.println(Math.min(mn, mx) + " " + Math.max(mn, mx));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve_kro(sc);
        }
    }
}