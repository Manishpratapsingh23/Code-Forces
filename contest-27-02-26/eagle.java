import java.io.*;
import java.util.*;

public class eagle {

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

    private static void solve_kro(FastScanner sc) throws Exception{
    	System.out.println("Hello...");
    	return;
        
    }

    static FastScanner sc = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int test = sc.nextInt();
        while (test-- > 0) {
            solve_kro(sc);
        }
    }

    static class FastScanner{
        BufferedReader br;
        StringTokenizer st;
        FastScanner(){ br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() throws Exception{
            while(st==null || !st.hasMoreElements()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws Exception{ return Integer.parseInt(next()); }
        long nextLong() throws Exception{ return Long.parseLong(next()); }
        String nextLine() throws IOException { return br.readLine(); }
        public double nextDouble() throws Exception { return Double.parseDouble(next()); }
    }
}



import java.io.*;
import java.util.*;

public class EasySegementTree {
    static long MOD = 1000000007L;
    static long INV2 = 500000004L; // Modular inverse of 2 modulo 10^9+7

    static class Node {
        long sum;
        long lazyX = -1; // -1 means no pending update
        long lazyY = 0;
        boolean hasLazy = false;
    }

    static Node[] tree;

    // Helper to apply an AP update to a specific node
    static void apply(int idx, int start, int end, long x, long y) {
        long n = (long)end - start + 1;
        
        // AP Sum Formula: (n / 2) * (2*a + (n-1)*d)
        // In our terms: (n * (2*x + (n-1)*y) * INV2) % MOD
        long term1 = (2 * x) % MOD;
        long term2 = ((n - 1) * y) % MOD;
        long total = (n * ((term1 + term2) % MOD)) % MOD;
        
        tree[idx].sum = (total * INV2) % MOD;
        tree[idx].lazyX = x;
        tree[idx].lazyY = y;
        tree[idx].hasLazy = true;
    }

    // Push pending updates down to children
    static void push(int idx, int start, int end) {
        if (!tree[idx].hasLazy) return;

        int mid = start + (end - start) / 2;
        
        // Left child gets the same starting x and y
        apply(2 * idx + 1, start, mid, tree[idx].lazyX, tree[idx].lazyY);
        
        // Right child starts where the left child left off
        long leftCount = (long)mid - start + 1;
        long rightX = (tree[idx].lazyX + (leftCount * tree[idx].lazyY) % MOD) % MOD;
        apply(2 * idx + 2, mid + 1, end, rightX, tree[idx].lazyY);

        // Reset current node's lazy status
        tree[idx].hasLazy = false;
        tree[idx].lazyX = -1;
    }

    static void build(int idx, int start, int end, long[] arr) {
        tree[idx] = new Node();
        if (start == end) {
            tree[idx].sum = arr[start] % MOD;
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * idx + 1, start, mid, arr);
        build(2 * idx + 2, mid + 1, end, arr);
        tree[idx].sum = (tree[2 * idx + 1].sum + tree[2 * idx + 2].sum) % MOD;
    }

    static void update(int idx, int start, int end, int l, int r, long x, long y) {
        if (start > r || end < l) return;
        
        if (start >= l && end <= r) {
            // Find the starting value of the AP for this specific segment
            long offset = (long)start - l;
            long currentX = (x + (offset * y) % MOD) % MOD;
            apply(idx, start, end, currentX, y);
            return;
        }

        push(idx, start, end);
        int mid = start + (end - start) / 2;
        update(2 * idx + 1, start, mid, l, r, x, y);
        update(2 * idx + 2, mid + 1, end, l, r, x, y);
        tree[idx].sum = (tree[2 * idx + 1].sum + tree[2 * idx + 2].sum) % MOD;
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        // The samples don't suggest multiple test cases, but I'll follow your main structure
        // If there is only one test case, change this logic accordingly.
        try {
            String line = sc.next();
            if (line == null) return;
            int n = Integer.parseInt(line);
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextLong();

            tree = new Node[4 * n];
            build(0, 0, n - 1, arr);

            int q = sc.nextInt();
            while (q-- > 0) {
                int ql = sc.nextInt();
                int qr = sc.nextInt();
                long qx = sc.nextLong();
                long qy = sc.nextLong();
                update(0, 0, n - 1, ql, qr, qx, qy);
            }
            System.out.println(tree[0].sum % MOD);
        } catch (Exception e) {}
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { return null; }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }
}