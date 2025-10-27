import java.util.*;
public class alpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
       
    }

    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(s.charAt(i)=='1'){
                if(stack.isEmpty()){
                    ans++;
                    stack.push(i);
                } else {
                    if((i-k) <= stack.peek()-1){
                        // continue;
                    } else {
                        ans++;
                    }
                    stack.push(i);
                }
            }
        }
        System.out.println(ans);
    }
}
