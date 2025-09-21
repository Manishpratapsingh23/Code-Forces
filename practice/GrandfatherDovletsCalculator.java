import java.util.Scanner;

public class GrandfatherDovletsCalculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        solve(a,b);
    }

    private static void solve(int a, int b){
        
        int ans = 0;
        int segements[] = {6,2,5,5,4,5,6,3,7,6};
        for(int i=a;i<=b;i++){
            int n = i;
            while(n>0){
                ans += segements[n%10];
                n /=10;
            }
        }
        System.out.println(ans);
    }
    // private static int compute(String n){
    //     int segements[] = {6,2,5,5,4,5,6,3,7,8};
    //     int ans = 0;
    //     for(char ch : n.toCharArray()){
    //         ans += segements[ch-'0'];
    //     }
    //     return ans;
    // }
}