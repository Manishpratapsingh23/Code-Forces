import java.util.*;

public class alpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            dearrangement(arr);
    }
    }
    private static void dearrangement(int a[]){
        int n=a.length;
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
