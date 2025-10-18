import java.util.Scanner;
public class beta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
       
    }

    private static void solve_kro(Scanner sc){
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        boolean b = ((x & y & ~z) != 0L) 
          || ((x & z & ~y) != 0L) 
          || ((y & z & ~x) != 0L);
          String ans = b ? "No" : "Yes";
        System.out.println(ans);

    }
}
