import java.io.*;
import java.util.*;

public class Tree_01 {

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
    static int prev[];
    static int nxt[];
    static int arr[];
    static int n;
    static boolean used[];
    private static void solve_kro(FastScanner sc) throws Exception{
    	n = sc.nextInt();
    	prev = new int[n+2];
    	nxt = new int[n+2];
    	arr = new int[n+2];
    	used = new boolean[n+2];
    	for(int i=1;i<=n;i++){
    		arr[i] = sc.nextInt();
    		prev[i]=i-1;
    		nxt[i]=i+1;
    	}
    	arr[0]=-2;
    	arr[n+1]=-2;
	    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[0]-a[0]);
	    for(int i=1;i<=n;i++){
	    	if(good(i)){
	    		used[i]=true;
	    		pq.add(new int[]{arr[i], i});
	    	}
	    }
	    while(!pq.isEmpty()){
	    	int top[] = pq.remove();
	    	int i = top[1];
	    	nxt[prev[i]]=nxt[i];
	    	prev[nxt[i]]=prev[i];
	    	if(!used[prev[i]] && good(prev[i])){
	    		used[prev[i]]=true;
	    		pq.add(new int[]{arr[prev[i]], prev[i]});
	    	}
	    	if(!used[nxt[i]] && good(nxt[i])){
	    		used[nxt[i]]=true;
	    		pq.add(new int[]{arr[nxt[i]], nxt[i]});
	    	}
	    }

	    int min=n,bad=0;
	    for(int i=1;i<=n;i++){
	    	if(!used[i]) bad++;
	    	min = Math.min(arr[i],min);
	    }

	    if(bad == 1 && min == 0){
	    	System.out.println("Yes");
	    	return;
	    }
	    System.out.println("No");

	}

    static boolean good(int i){
    	if(i<1 || i>n){
    		return false;
    	}

    	return arr[i]-1==arr[prev[i]] || arr[i]-1==arr[nxt[i]];
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