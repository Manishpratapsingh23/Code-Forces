import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();  // number of test cases

        while (T-- > 0) {
            int n = sc.nextInt();  // size of array
            int k = sc.nextInt();  // 1-based index
            int[] h = new int[n];

            for (int i = 0; i < n; i++) {
                h[i] = sc.nextInt();
            }

            int hk = h[k - 1];
            int Hmax = Arrays.stream(h).max().getAsInt();

            if (hk == Hmax) {
                System.out.println("YES");
                continue;
            }

            // Copy and sort unique elements
            TreeSet<Integer> set = new TreeSet<>();
            for (int x : h) set.add(x);

            List<Integer> v = new ArrayList<>(set);

            int pos = Collections.binarySearch(v, hk);
            boolean ok = true;

            for (int i = pos; i + 1 < v.size(); i++) {
                if (v.get(i + 1) - v.get(i) > hk) {
                    ok = false;
                    break;
                }
            }

            if (ok) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
