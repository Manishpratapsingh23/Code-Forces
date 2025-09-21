import java.util.*;

public class DerangedDeletions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                System.out.println("YES\n2");
                System.out.println(a[i] + " " + a[i + 1]);
                return;
            }
        }

        System.out.println("NO");
    }
}
}
