import java.util.Scanner;

public class KDivisibleSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
       
    }

    private static void solve_kro(Scanner sc){
        long n = sc.nextLong();
        long k = sc.nextLong();
        long cf = (n+k-1)/k;
        long ans = (cf*k+n-1)/n;
        System.out.println(ans);
    }
}
