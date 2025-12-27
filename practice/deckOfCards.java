import java.util.Scanner;

public class deckOfCards {
    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();
        String ops = sc.next();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) sb.append('+');
        int a=0,b=0,c=0;
        
        for(char ch : ops.toCharArray()){
            if(ch=='0') a++;
            else if(ch=='1') b++;
            else c++;
        }
        for(int i=0;i<n;i++){
            if(i<a+c || i>=n-b-c) sb.setCharAt(i, '?');
            if(i<a || i >= n-b || n==k) sb.setCharAt(i, '-');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve_kro(sc);
        }
    }
}