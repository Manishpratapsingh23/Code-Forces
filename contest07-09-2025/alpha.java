import java.util.*;

public class alpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
       
    }

    private static void solve_kro(Scanner sc){
        int k = sc.nextInt();
        int x = sc.nextInt();
        long ans = x<<k;
        System.out.println(ans);
    }
}
