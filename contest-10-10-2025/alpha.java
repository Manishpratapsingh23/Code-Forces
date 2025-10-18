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
        Set<Integer> apple = new HashSet<>();
        for(int i=0 ;i<n;i++) apple.add(sc.nextInt());
        System.out.println(apple.size());
    }
}
