import java.util.Arrays;
import java.util.Scanner;

public class beta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long test = sc.nextLong();

        while (test-- > 0) {
            solve_kro(sc);
        }
       
    }

    private static void solve_kro(Scanner sc){
        //Scanner sc = new Scanner(System.in);
        int gears = sc.nextInt();
        long teeth[] = new long[gears];
        for(int i=0;i<gears;i++){
            teeth[i] = sc.nextLong();
        }
        long ans = 0;
        int i = gears%2==0 ? 1: 0;
        Arrays.sort(teeth);
        for( ;i<gears;i+=2){ ans+=teeth[i];
        }
        System.out.println(ans);
    }
}
