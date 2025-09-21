import java.util.*;

public class charlie1 {
    private static Map<String, Integer> memo;
    private static List<Integer> lst, best;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve_kro(sc);
        }
    }

    private static void solve_kro(Scanner sc) {
        int k = sc.nextInt();
        int x = sc.nextInt();
        long initial = 1L << k; // 2^k
        memo = new HashMap<>();
        lst = new ArrayList<>();
        best = new ArrayList<>();
        helper(initial, initial, x);
        System.out.println(best.size());
        for (int op : best) {
            System.out.print(op + " ");
        }
        System.out.println();
    }

    private static int helper(long coke, long van, int x) {
        if (coke == x) {
            best = new ArrayList<>(lst); // store successful path
            return 0;
        }
        if ((coke & 1) == 1 && (van & 1) == 1) return 123;

        String key = coke + "," + van;
        if (memo.containsKey(key)) return memo.get(key);

        int res = 123;

        if ((coke & 1) == 0) {
            lst.add(1);
            int op1 = 1 + helper(coke / 2, van + coke / 2, x);
            if (op1 < res) res = op1;
            lst.remove(lst.size() - 1);
        }

        if ((van & 1) == 0) {
            lst.add(2);
            int op2 = 1 + helper(coke + van / 2, van / 2, x);
            if (op2 < res) res = op2;
            lst.remove(lst.size() - 1);
        }

        memo.put(key, res);
        return res;
    }
}
