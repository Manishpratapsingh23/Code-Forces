import java.util.PriorityQueue;
import java.util.Scanner;

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
       int m = sc.nextInt();
       PriorityQueue<Long> pq = new PriorityQueue<>((a,b) -> Long.compare(b,a));
       int t = 0;
       while(t++ < n){
        long num = sc.nextLong();
        pq.add(num);
       }
       long ans = 0;
       while(!pq.isEmpty() && m > 0){
        ans+= pq.poll()*m--;
       }
       System.out.println(ans);
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
