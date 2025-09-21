import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class delta1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
        sc.close();
    }

    private static void solve_kro(Scanner sc) {
        int n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = b[i];
            map.computeIfAbsent(num, k -> new ArrayList<>()).add(i);
        }

        boolean ok = true;
        for (int v = 1; v <= n; v++) {
            if (map.containsKey(v)) {
                if (map.get(v).size() % v != 0) {
                    ok = false;
                    break;
                }
            }
        }

        if (!ok) {
            System.out.println(-1);
            return;
        }

        int[] a = new int[n];
        int lab = 1;

        for (int v = 1; v <= n; v++) {
            if (!map.containsKey(v)) continue;

            List<Integer> lst = map.get(v);
            int m = lst.size();

            for (int i = 0; i < m; i += v) {
                for (int j = 0; j < v; j++) {
                    a[lst.get(i + j)] = lab;
                }
                lab++;
            }
        }

        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
}
