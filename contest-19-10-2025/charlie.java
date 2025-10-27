import java.util.Arrays;
import java.util.Scanner;

public class charlie {

    private static int[] sieveEratosthenes(int n) {
        int prime[] = new int[n + 1];
        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 0;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = 0;
                }
            }
        }
        return prime;
    }

    private static int solve(Scanner sc) {
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        for (int i = 0; i < n; i++) sc.nextInt();
        //Arrays.sort(nums);
        int max = 200000;
        int prime[] = sieveEratosthenes(max);

        for (int p = 2; p <= max; p++) {
            if (prime[p] == 1) {
                int cnt1 = 0, cnt2 = 0;
                for (int i : nums) {
                    if (i!=1 && i % p == 0) cnt1++;
                    if (i!=1 && (i + 1) % p == 0) cnt2++;
                }
                if (cnt1 > 1) return 0;  
                if (cnt2 > 1) return 1; 
            }
        }
        return 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println(solve(sc));
        }
    }
}
