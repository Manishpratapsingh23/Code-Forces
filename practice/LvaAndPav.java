import java.io.*;
import java.util.*;

public class LvaAndPav {

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
    	int arr[] = new int[n+1];
    	int prefix[][] = new int[n+1][31];
    	Arrays.fill(prefix[0],0);
    	for(int i=1;i<=n;i++){
    		int x = sc.nextInt();
    		arr[i]=x;
    		for(int bit=0;bit<31;bit++){
    			prefix[i][bit] = prefix[i-1][bit]+((x>>bit)&1);
    		}
    	}

	    	// for(int a[] : prefix){
	    	// 	for(int i : a){
	    	// 		System.out.print(i+" ");
	    	// 	}
	    	// 	System.out.println();
	    	// }

    	int q = sc.nextInt();

    	while(q-- > 0){
    		int ll = sc.nextInt();
    		int ans = ll;
    		int k = sc.nextInt();
    		if(arr[ll]<k){
    			System.out.print(-1+" ");
    			continue;
    		}
    		int l = ll;
    		int r = n;
    		while(l<=r){
    			int m = l+(r-l)/2;
    			int req = m-ll+1;
    			int num = 0;
    			for(int i=0;i<31;i++){
    				int bit = (prefix[m][i]-prefix[ll-1][i])==req ? 1 : 0;
    				bit = bit&(arr[ll]>>i);
    				num = num | (bit<<i);
    			}
    			if(num>=k){
    				l=m+1;
    			} else {
    				r=m-1;
    			}
    		}
    		System.out.print(r+" ");
    	}
        System.out.println();
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