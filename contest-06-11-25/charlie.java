import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class charlie {
    static class Pair implements Comparable<Pair>{
        long a, b;
        Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Pair other) {
            // Sort by life value ascending
            return Long.compare(this.a, other.a);
        }
    }

    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Long> sword = new PriorityQueue<>();
        Pair life[] = new Pair[m];

        for(int i=0;i<n;i++) sword.add(sc.nextLong());
        long monster[] = new long[m];
        for(int i=0;i<m;i++) monster[i] = sc.nextLong();
        for(int i=0;i<m;i++){
            long power = sc.nextLong();
            Pair p = new Pair(monster[i], power);
            life[i] = p;
        }
        Arrays.sort(life);

        int ans = 0;
        for(Pair p : life){
            if(!sword.isEmpty() && sword.peek()>=p.a){
                long power = sword.poll();
                ans++;
                if(p.b>0){
                    sword.add(Math.max(power, p.b));
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve_kro(sc);
        }
    }
}
