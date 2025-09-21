import java.util.*;

public class beta{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
       
    }

    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();
        //int arr[] = new int[n];
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            System.out.print((n+1-num)+" ");
        }
        System.out.println();
    }

    // private static int GCD(int a, int b){
    //     while (b != 0) {
    //         int temp = b;
    //         b = a % b;  // remainder
    //         a = temp;
    //     }
    //     return a;
    // }
}
