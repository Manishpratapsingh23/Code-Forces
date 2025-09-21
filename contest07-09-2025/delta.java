import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class delta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
       
    }

    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            List<Integer> lst = map.getOrDefault(num, new ArrayList<>());
            lst.add(i);
            map.put(num, lst);
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
        int k =2;
        int ans[] = new int[n];
        for(int i : map.keySet()){
            List<Integer> lst =  map.get(i);
            for(int j : lst) ans[j] = k;
            k++;
        }

        for(int i : ans){
            System.out.print(i+" ");
        }
        System.out.println("");
    }
}
