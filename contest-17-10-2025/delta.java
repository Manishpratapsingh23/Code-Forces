import java.util.Scanner;
public class delta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
       
    }

    private static void solve_kro(Scanner sc){
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a<b){
            System.err.println(-1);
            return;
        }
        System.out.println("1");
        System.out.println(a^b);
    }
}
