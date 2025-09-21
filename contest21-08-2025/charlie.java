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
        int n = sc.nextInt();
        long cost = 0;
        int x = 0;
        while(n>0){
            int d = n%3;
            if(d>0){
                long deal_cost = (long)(Math.pow(3,x+1) + (x==0 ? 0 : (x*(long)Math.pow(3, x-1))));
                cost += d*deal_cost;
            }
            n /= 3;
            x++;
        }
        System.out.println(cost);
    }
}
