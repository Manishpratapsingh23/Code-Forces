import java.io.*;
import java.util.*;

public class ZeroQuantityMaximization {

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

    private static long GCD(long a, long b){
        a = Math.abs(a);
        b = Math.abs(b);
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
    	int n = sc.nextInt();
    	long a[] = new long[n];
    	long b[] = new long[n];
    	for(int i=0;i<n;i++) a[i]=sc.nextLong();
    	for(int i=0;i<n;i++) b[i]=sc.nextLong();
    	Map<pair, Long> map = new HashMap<>();
    	long ans = 0;
    	for(int i=0;i<n;i++){
    		if(a[i]==0){
    			if(b[i]==0) ans++;
    			continue;
    		}
            long p=-b[i];
            long q=a[i];
    		long gcd = GCD(p, q);
    	    p = p/gcd;
            q = q/gcd;
    		if(q<0){
                p*=-1;
                q*=-1;
            }
            pair pp = new pair(p,q);
            map.put(pp, map.getOrDefault(pp,0L)+1);

        	//ans = Math.max(ans, count);
    	}
        long max = 0;
        for(pair key : map.keySet()){
            max = Math.max(max, map.get(key));
        }
    	System.out.println(max+ans);
        
    }
    private static final class pair {
        final long p; // numerator
        final long q; // denominator (always non-negative after normalization)

        pair(long p, long q) {
            this.p = p;
            this.q = q;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof pair)) return false;
            pair other = (pair) o;
            return p == other.p && q == other.q;
        }

        @Override
        public int hashCode() {
            return Objects.hash(p, q);
        }
    }

    static FastScanner sc = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        //int test = sc.nextInt();
       // while (test-- > 0) {
            solve_kro(sc);
        //}
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