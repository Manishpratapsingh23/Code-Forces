import java.util.Scanner;

public class charlie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
       
    }

    private static void solve_kro(Scanner sc){
        long a = sc.nextLong();
        long b = sc.nextLong();
        if(b%2==1){
            if(a%2==1){
                System.out.println(a*b+1);
                return;
            }
            else{
                System.out.println(-1);
                return;
            }
        }
        long bb = b, k =0;
        while(bb%2==0){
            bb >>= 1;
            k++;
        }
        if(a%2==1 && k==1){
            System.out.println(-1);
                return;
        }

        long ans1 = a*(b/2)+2;
        k = a%2==1 ? 2 : 1;
        long ans2 = a*k+b/k;
        System.out.println(Math.max(ans1,ans2));
    }
}
