import java.util.Scanner;

public class alpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
       
    }

    private static void solve_kro(Scanner sc){
        long a = sc.nextInt();
        long b = sc.nextInt();
        if(a==b){
            System.out.println(0);
            return;
        }
        if(a==1 || b==1 ||a%b==0 || b%a==0){
            System.out.println("1");
            return;
        }
        System.out.println(2);
    }
}
