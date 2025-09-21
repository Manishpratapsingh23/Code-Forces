import java.util.Arrays;
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
        //Scanner sc = new Scanner(System.in);
        int gears = sc.nextInt();
        int teeth[] = new int[gears];
        for(int i=0;i<gears;i++){
            teeth[i] = sc.nextInt();
        }
        Arrays.sort(teeth);
        for(int i=1;i<gears;i++){
            if(teeth[i-1]==teeth[i]){
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
