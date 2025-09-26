import java.util.Scanner;
public class BePositive{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0)  solve(sc);
    }

    private static void solve(Scanner sc){
        int n = sc.nextInt();
        int negative = 0, zero = 0;
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            if(num==-1) negative++;
            else if(num==0) zero++;
        }

        int ans = 0;
        ans+=zero;
        if(negative%2==1) ans+=2;
        System.out.println(ans);
    }
}