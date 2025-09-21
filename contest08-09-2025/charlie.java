import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class charlie {
    private static List<Integer> lst;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
       
    }

    private static void solve_kro(Scanner sc){
        lst = new ArrayList<>();
        int k = sc.nextInt();
        int x = sc.nextInt();
        long initial_cakes = (long)(Math.pow(2,k));
        int ans = helper(initial_cakes, initial_cakes,x);
        System.out.println(ans);
        for (int i : lst) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int helper(long coke, long van, int x){
    if (coke == x) return 0;
    if (coke % 2 == 1 && van % 2 == 1) return 123;

    int op1 = 121;
    int op2 = 121;

    if (coke % 2 == 0) {
        lst.add(1);
        op1 = 1 + helper(coke / 2, van + coke / 2, x);
        if (op1 >= 123) lst.remove(lst.size() - 1);
    }

    if (van % 2 == 0) {
        lst.add(2); 
        op2 = 1 + helper(coke + van / 2, van / 2, x);
        if (op2 >= 123) lst.remove(lst.size() - 1);
    }

    return Math.min(op1, op2);
}

}
