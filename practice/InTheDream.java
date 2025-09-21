import java.util.*;
public class InTheDream {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) solve(sc);

    }

    private static void solve(Scanner sc){
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        if(Math.max(a,b) > 2*Math.min(a,b)+2)    System.out.println("No");
        else if(Math.max(c-a,d-b) > 2*Math.min(c-a,d-b)+2)    System.out.println("No");
        else {
            System.out.println("Yes");
        }
    }
}
