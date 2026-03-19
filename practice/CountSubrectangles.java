import java.io.*;
import java.util.*;

public class CountSubrectangles {

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
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	int k = sc.nextInt();
    	int a[] = new int[n];
    	int b[] = new int[m];

    	for(int i=0;i<n;i++) a[i]=sc.nextInt();
    	for(int i=0;i<m;i++) b[i]=sc.nextInt();

    	long fa[] = new long[n+1];
    	long fb[] = new long[m+1];

    	int c=0;
    	for(int i=0;i<n;i++){
    		if(a[i]==1){
    			c++;
    			fa[c]++;
    		} else {
    			c=0;
    		}
    	}

    	c=0;
    	for(int i=0;i<m;i++){
    		if(b[i]==1){
    			c++;
    			fb[c]++;
    		} else {
    			c=0;
    		}
    	}

    	for(int i=n;i>0;i--){
    		fa[i-1]+=fa[i];
    	}
    	for(int i=m;i>0;i--){
    		fb[i-1]+=fb[i];
    	}

    	long ans=0L;
    	for(long i=1;i*i<=k;i++){
    		if(k%i==0){
    			long j=k/i;
    			if(i<=n && j<=m){
    				ans+=fa[(int)i]*fb[(int)j];
    			}
    			if(i!=j && i<=m && j<=n){
    				ans+=fa[(int)j]*fb[(int)i];
    			}

    		}
    	}

    	System.out.println(ans);
        
    }

    static FastScanner sc = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        //int test = sc.nextInt();
        //while (test-- > 0) {
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