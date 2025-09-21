import java.util.Scanner;

public class theGoodArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
       
    }

    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();
        double ans = Math.ceil((double)(n - 1) / k) + 1;
        System.out.println((int)(ans));
    }
}
