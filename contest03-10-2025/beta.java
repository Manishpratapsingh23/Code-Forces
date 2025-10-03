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
        long n = sc.nextLong();
        long kr = sc.nextLong();
        long kc = sc.nextLong();
        long dr = sc.nextLong();
        long dc = sc.nextLong();
        // long ans = n;
        // if(dc==0 || dr==0){
        //     System.out.println(n);
        //     return;
       
        long low = 0;
        long high = Math.max(Math.max(dr, n-dr), Math.max(dc, n-dc));
        while(low<high){
            long mid = low + (high-low)/2;
            if(eval(n, kr, kc, dr, dc, mid) >= mid+1) low = mid+1;
            else high = mid;
        }
        System.out.println(low);

    }
    private static long eval(long n, long rK, long cK, long dr, long dc, long s) {
        long rL = Math.max(0, rK - s);
        long rR = Math.min(n, rK + s);
        long cL = Math.max(0, cK - s);
        long cR = Math.min(n, cK + s);

        long r= Math.max(Math.abs(rL - dr), Math.abs(rR - dr));
        long c = Math.max(Math.abs(cL - dc), Math.abs(cR - dc));

        return Math.max(r, c);
    }
}
