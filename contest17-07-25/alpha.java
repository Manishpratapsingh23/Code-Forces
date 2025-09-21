import java.util.Scanner;

public class alpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            int ans = 10;
            while(n!=0){
                int r = n%10;
                ans = Math.min(ans,r);
                n = n/10;
            }
            System.out.println(ans);
        }
        
    }
}