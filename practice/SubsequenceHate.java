import java.util.Scanner;

public class SubsequenceHate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            solve(sc);
        }
    }

    private static void solve(Scanner sc){
        String s = sc.next();
        int l = s.length();
        int zero = 0,one = 0,done_one=0, done_zero=0;
        for(char ch : s.toCharArray()){
            if(ch=='1') one++;
            else zero++;
        }
        int ans = 10000;
        for(char ch : s.toCharArray()){
            if(ch=='1') done_one++;
            else done_zero++;
            int ans1 = done_zero + one - done_one;
            int ans2 = done_one + zero - done_zero;
            ans = Math.min(ans, Math.min(ans1, ans2));
        }
        System.out.println(ans);
    }
}
