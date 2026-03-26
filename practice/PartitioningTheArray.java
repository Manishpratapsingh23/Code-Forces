import java.io.*;
import java.util.*;

public class PartitioningTheArray {
    private static int GCD(int a, int b){
        while(a>0 && b>0){
            if(a>b) a = a%b;
            else b = b%a;
        }
        if(a==0) return b;
        return a;
    }

    static List<Integer> divisors(int n){
    	List<Integer> res = new ArrayList<>();
    	for(int i=1;i*i<=n;i++){
    		if(n%i!=0) continue;
    		res.add(i);
    		if(n/i!=i) res.add(n/i);
    	}
    	return res;
    }
    static List<Integer> div;
    private static void solve_kro(FastScanner sc) throws Exception{
    	int n = sc.nextInt();
    	int arr[] = new int[n];
    	for(int i=0;i<n;i++) arr[i]=sc.nextInt();
    	div = divisors(n);
    	int ans = 0;
    	for(int k : div){
    		int g = 0;
    		for(int i=k;i<n;i++){
    			int diff = Math.abs(arr[i]-arr[i-k]);
    			g = GCD(g, diff);
    		}
    		if(g!=1) ans++;
    	}
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