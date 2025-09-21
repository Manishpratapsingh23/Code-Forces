import java.util.Scanner;

public class beta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
           int n = sc.nextInt();
           int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = sc.nextInt();
            }

            System.out.println(canBeBeautiful(arr));
        }
    }

    private static int canBeBeautiful(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; ++i) {
            if (Math.abs(arr[i] - arr[i+1]) <= 1)
                return 0;
        }

        for (int i = 0; i < n - 1; ++i) {
            int L = Math.min(arr[i], arr[i + 1]);
            int R = Math.max(arr[i], arr[i + 1]);
            
            if (i - 1 >= 0) {
                int v = arr[i - 1];
                if (R >= v - 1 && L <= v + 1)
                    return 1;
            }

            if (i + 2 < n) {
                int v = arr[i + 2];
                if (R >= v - 1 && L <= v + 1)
                    return 1;
            }
        }

        return -1;
    }

    
}