import java.io.*;
import java.util.*;

public class SumOfDigits {

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


    static void cal(int ff[], long num){
    	while(num>0){
    		ff[(int)num%10]++;
    		num/=10;
    	}
    }

    static long digSum(long num){
    	long ss = 0;
    	while(num>0){
    		ss+=num%10;
    		num/=10;
    	}
    	return ss;
    }

    private static void solve_kro(FastScanner sc) throws Exception{
    	String s = sc.next();
    	int n = s.length();
    	if(n==1){
    		System.out.println(s);
    		return;
    	}

    	int freq[] = new int[10];
    	long sum = 0;
    	for(char ch : s.toCharArray()){
    		freq[ch-'0']++;
    		sum+=(ch-'0');
    	}

    	for(long x = 1;x<=sum;x++){
    		int ff[] = new int[10];
    		long num = x;
    		while(num>9){
    			cal(ff, num);
    			num = digSum(num);
    		}
    		ff[(int)num]++;
    		boolean pos = true;
    		long ss=0L;
    		for(int i=0;i<10;i++){
    			if(freq[i]<ff[i]) pos = false;
    			ss+=i*ff[i];
    		}

    		if(!pos || sum-ss!=x) continue;

    		for(int i=1;i<10;i++){
    			for(int j=0;j<freq[i]-ff[i];j++){
    				System.out.print(i);
    			}
    		}
    		for(int j=0;j<freq[0]-ff[0];j++){
    			System.out.print(0);
    		}
    		num=x;
    		while(num>9){
    			System.out.print(num);
    			num = digSum(num);
    		}
    		System.out.print(num);
    		System.out.println();
    		return;
    	}

        
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