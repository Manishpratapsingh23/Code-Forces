import java.io.*;
import java.util.*;

public class alpha {
    // prime check TC: O(underroot N)
    private static boolean checkPrime(int n){
        int count = 0;
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                count++;
                if((n/i)!=i) count++;
            }
            if(count>2) return false;
        }
        return true;
    }

    private static int GCD(int a, int b){
        while(a>0 && b>0){
            if(a>b) a = a%b;
            else b = b%a;
        }
        if(a==0) return b;
        return a;
    }

    // Prime Factors TC: O(underroot N)
    private static List<Integer> primeFactors(int n){
        List<Integer> factors = new ArrayList<>();
        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i==0){
                factors.add(i);
                while(n%i==0) n = n/i;
            }
        }
        if(n!=1) factors.add(n);
        return factors;
    }

    // Sieve of Eratosthenes
    // TC: n*log(log(n))
    // SC: O(n)
    private static int[] SieveEratosthenes(int n){
        int prime[] = new int[n+1];
        Arrays.fill(prime, 1);
        prime[0]=0;
        prime[1]=0;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(prime[i]==1){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=0;
                }
            }
        }
        return prime;
    }

    // Smallest Prime Factors
    private static List<Integer> SPF(int n){
        List<Integer> lst = new ArrayList<>();
        int spf[] = SOE(100000);
        while(n!=1){
            lst.add(spf[n]);
            n = n/spf[n];
        }
        return lst;
    }

    private static int[] SOE(int n){
        int spf[] = new int[(int) (n+1)];
        for(int i=1;i<=n;i++) spf[i]=i;
        for(int i=2;i*i<=n;i++){
            if(spf[i]==i){
                for(int j=i*i;j<=n;j+=i){
                    if(spf[j]==j){
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }

    static class Pair {
        long x;
        int delta;
        Pair(long x, int delta) {
            this.x = x;
            this.delta = delta;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        final long MINB = 0;
        final long MAXB = 2000000000L;

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = fs.nextInt();
            long a = fs.nextLong();

            long[] v = new long[n];
            for (int i = 0; i < n; i++) v[i] = fs.nextLong();

            ArrayList<Pair> ev = new ArrayList<>(2 * n);

            for (int i = 0; i < n; i++) {
                if (v[i] == a) continue;

                long other = 2L * v[i] - a;   // endpoint of open interval relative to 'a'
                long L0 = Math.min(a, other);
                long R0 = Math.max(a, other);

                // real open interval (L0, R0) -> integer interval [L0+1, R0-1]
                long L = L0 + 1;
                long R = R0 - 1;

                if (L > R) continue;
                if (R < MINB || L > MAXB) continue;

                L = Math.max(L, MINB);
                R = Math.min(R, MAXB);

                ev.add(new Pair(L, +1));
                ev.add(new Pair(R + 1, -1));
            }

            if (ev.isEmpty()) {
                out.append("0\n");
                continue;
            }

            // Sort by position
            ev.sort(Comparator.comparingLong(o -> o.x));

            // Combine equal positions
            ArrayList<Pair> pts = new ArrayList<>();
            for (int i = 0; i < ev.size(); ) {
                long x = ev.get(i).x;
                int sum = 0;
                while (i < ev.size() && ev.get(i).x == x) {
                    sum += ev.get(i).delta;
                    i++;
                }
                pts.add(new Pair(x, sum));
            }

            long bestCount = -1;
            long bestPos = 0;
            long curr = 0;

            for (int i = 0; i < pts.size(); i++) {
                long x = pts.get(i).x;
                curr += pts.get(i).delta;

                long next_x = (i + 1 < pts.size() ? pts.get(i + 1).x : (MAXB + 2));
                long segL = Math.max(x, MINB);
                long segR = Math.min(next_x - 1, MAXB);

                if (segL <= segR) {
                    if (curr > bestCount) {
                        bestCount = curr;
                        bestPos = segL;  // leftmost valid b
                    }
                }
            }

            if (bestCount <= 0) out.append("0\n");
            else out.append(bestPos).append("\n");
        }

        System.out.print(out);
    }

    // Fast Scanner (much faster than Java Scanner)
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return -1;
            long sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            long val = c - '0';
            while ((c = read()) > ' ') val = val * 10 + (c - '0');
            return val * sign;
        }

        int nextInt() throws IOException { return (int) nextLong(); }
    }
}
