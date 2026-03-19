import java.io.*;
import java.util.*;

public class beta {

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
    	int k = sc.nextInt();
    	int p = sc.nextInt();
    	int m = sc.nextInt();
    	int arr[] = new int[n+1];
    	long prefix[] = new long[n+1];
    	prefix[0]=0;
    	for(int i=1;i<=n;i++) arr[i]=sc.nextInt();
    	int ans = 0;
    	if(p<k){
    		ans++;
    		m-=arr[p];
    		int xx = arr[p];
    		for(int i=p;i<n-1;i++) arr[i]=arr[i+1];
    		arr[n]=xx;
    		p=n;
    	}

    	for(int i=1;i<=n;i++){
    		prefix[i]=prefix[i-1]+arr[i];
    	}

    	
    	m-=(prefix[p-1]-prefix[k-1]);

    	long cost = prefix[n]-prefix[k-1];
    	ans+=(m/cost);
    	System.out.println(ans);

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

import java.util.Arrays;

private static void solve_kro(FastScanner sc) throws Exception {
    int n = sc.nextInt();
    int k = sc.nextInt();
    int p = sc.nextInt() - 1; // Convert to 0-based indexing for easier math
    long m = sc.nextLong();   // Use long to prevent integer overflow

    long[] a = new long[n];
    for (int i = 0; i < n; i++) {
        a[i] = sc.nextLong();
    }

    long targetCost = a[p];

    // --- PHASE 1: Cost to reach and play the target the VERY FIRST time ---
    // Extract the cards sitting in front of the target
    long[] beforeTarget = new long[p];
    for (int i = 0; i < p; i++) {
        beforeTarget[i] = a[i];
    }
    
    // Sort so the cheapest are at the beginning, most expensive at the end
    Arrays.sort(beforeTarget);

    long costFirst = targetCost;
    int holdFirst = Math.min(p, k - 1); 
    
    // We pay for the cards before the target, EXCEPT the ones we can hold in our buffer
    for (int i = 0; i < p - holdFirst; i++) {
        costFirst += beforeTarget[i];
    }

    // If we can't even afford the first play, output 0 and exit
    if (m < costFirst) {
        System.out.println(0);
        return;
    }

    // --- PHASE 2: Cost to cycle the whole deck for subsequent plays ---
    // Extract ALL non-target cards
    long[] allOther = new long[n - 1];
    int idx = 0;
    for (int i = 0; i < n; i++) {
        if (i != p) {
            allOther[idx++] = a[i];
        }
    }
    
    Arrays.sort(allOther);

    long costCycle = targetCost;
    int holdCycle = Math.min(n - 1, k - 1);
    
    // We pay to cycle the deck, skipping the absolute most expensive cards overall
    for (int i = 0; i < (n - 1) - holdCycle; i++) {
        costCycle += allOther[i];
    }

    // --- FINAL CALCULATION ---
    // 1 for the first play, plus however many full cycles we can afford
    long ans = 1 + ((m - costFirst) / costCycle);
    System.out.println(ans);
}