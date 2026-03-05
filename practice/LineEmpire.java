import java.io.*;
import java.util.*;

public class LineEmpire {

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
    static Map<String, Long> map;
    private static void solve_kro(FastScanner sc) throws Exception{
    	map = new HashMap<>();
    	int n = (int)sc.nextLong();
    	long a = sc.nextLong();
    	long b = sc.nextLong();
    	long pos[] = new long[n+1];
    	pos[0]=0L;
        long prefix[] = new long[n+1];
        prefix[0]=0L;
    	for(int i=1;i<=n;i++){
            pos[i]=sc.nextLong();
            prefix[i] = pos[i]+prefix[i-1];
        }
    	long totalCost = Long.MAX_VALUE;
        for(int i=0;i<=n;i++){
            long ledftCost = (a+b)*pos[i];
            long rightCost = b*(prefix[n]-prefix[i]-(n-i)*pos[i]);
            long total = ledftCost+rightCost;
            totalCost = Math.min(totalCost, total);
        }

        
        System.out.println(totalCost);
    }

    private static long helper(int prev, int curr, int pos[], int a, int b){
    	if(curr>=pos.length) return 0L;
        //if (prev > curr) return 0L;
    	String key = prev+" "+curr;
    	if(map.containsKey(key)) return map.get(key);
    	long op1 = helper(prev, curr+1, pos, a, b);
    	long op2 = a*(pos[curr]-pos[prev])+helper(prev+1, curr+1, pos, a, b);
    	long ans = b*(pos[curr]-pos[prev])+Math.min(op1, op2);
    	map.put(key, ans);
    	return ans;
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