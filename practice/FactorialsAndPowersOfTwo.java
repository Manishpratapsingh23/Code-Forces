import java.io.*;
import java.util.*;

public class FactorialsAndPowersOfTwo {

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
    static long ans;
    private static void solve_kro(FastScanner sc) throws Exception{
    	ans = 1000000000000L;
    	long n = sc.nextLong();
    	if((n&(n-1))==0){
    		System.out.println(1);
    		return;
    	}

    	for(int i=0;i<(1<<12);i++){
    		long sum = 0;
    		long cnt = 0;
    		for(int j=0;j<12;j++){
    			if((i&(1<<j))!=0){
    				cnt++;
    				sum+=fact[j];
    			}
    		}
    		if(sum>n) continue;
    		long rem = n-sum;
    		cnt+=CountSetBit(rem);
    		ans = Math.min(ans, cnt);
    	}

    	System.out.println(ans);
    }


    static long fact[] = new long[12];

    static int CountSetBit(long n){
    	 int cnt = 0;
	    while(n>0){
	        cnt += (n&1);
	        n >>= 1;
	    }
	    return cnt;
    }

    static FastScanner sc = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
    	fact[0]=6;
    	for(int i=4;i<15;i++) fact[i-3]=fact[i-4]*i;
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