import java.util.Scanner;

public class alpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            long op1 = (b-a)*x;
            long op2 = y+(b-a)*x;
            if(a==b) System.out.println(0);
            else if(a>b){
                if((a&1)==1 && b==a-1) System.out.println(y);
                else System.out.println(-1);
            }
            else{
                long ans = 0;
                for (long i = a; i < b; i++) {
                    if ((i & 1) == 1) {
                        ans += x;
                    } else {
                        ans += Math.min(x,y);
                    }
                }
                System.out.println(ans);
            }
        }
    }
}