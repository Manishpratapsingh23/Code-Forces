import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class RecamanQueries {

	 private static boolean checkPrime(int n){
        if(n<2) return false;
        for(int i=2;i * i <= n;i++){
            if(n%i==0) return false;
        }
        return true;
    }

    static int segement[];
    static int remacanDist[];
    static boolean fortunate[];
    static List<Integer> primes;
    
    private static void solve_kro(FastScanner sc) throws Exception{
    	int n = sc.nextInt();
    	int arr[] = new int[n];
    	for(int i=0;i<n;i++) arr[i]=sc.nextInt();
    	segement = new int[4*n];
    	build(0,0,n-1,arr);
    	compute();

    	int q = sc.nextInt();
    	long ans = 0;
    	while(q-->0){
    		int type = sc.nextInt();
    		if(type==0){
    			int i = sc.nextInt();
    			int x = sc.nextInt();
    			update(0,0,n-1,i,x);
    		} else {
    			int l = sc.nextInt();
    			int r = sc.nextInt();
    			int m = query(0,0,n-1,l,r);
                if(m<0) continue;
    			int dist = remacanDist[m];
                long mul = fortunate[m] ? 17 : 1;
                ans+=(dist*mul);
                //System.out.println(m+" "+dist*mul);
    		}
    	}
    	System.out.println(ans);
        
    }

    static void update(int idx, int start, int end, int i, int val){
    	if(start==end){
    		segement[idx]=val;
    		return;
    	}
    	int mid = start+(end-start)/2;
    	if(i<=mid) update(2*idx+1, start, mid, i, val);
    	else update(2*idx+2, mid+1, end, i , val);
    	segement[idx] = Math.max(segement[2*idx+1], segement[2*idx+2]);
    }

    static int query(int idx, int start, int end, int l, int r){
    	if(start>r || end<l) return -1;
    	if(start>=l && end<=r) return segement[idx];
    	int mid = start+(end-start)/2;
    	int left = query(2*idx+1, start, mid, l, r);
    	int right = query(2*idx+2, mid+1, end, l, r);
    	return Math.max(left, right);
    }

    static void build(int idx, int start, int end, int arr[]){
    	if(start==end){
    		segement[idx]=arr[start];
    		return;
    	}
    	int mid = start+(end-start)/2;
    	build(2*idx+1, start, mid, arr);
    	build(2*idx+2, mid+1, end, arr);
    	segement[idx] = Math.max(segement[2*idx+1], segement[2*idx+2]);
    }

    static void compute() {
        int max = 10001;
        remacanDist = new int[max];
        fortunate = new boolean[max];
        for (int i = 0; i < max; i++) {
            remacanDist[i] = getSteps(i);
        }
        // BigInteger primorial = BigInteger.valueOf(2);
        // BigInteger p = BigInteger.valueOf(2);

        // for (int n = 1; n < 50; n++) { // 40 primorials covers many Fortunates
        //     int m = 2;
        //     while (true) {
        //         if (primorial.add(BigInteger.valueOf(m)).isProbablePrime(10)) {
        //             if (m < max) fortunate[m] = true;
        //             break; // Smallest m found for this primorial
        //         }
        //         m++;
        //     }
        //     p = p.nextProbablePrime();
        //     primorial = primorial.multiply(p);
        //     primorial.multiply(p);
        // }
        long primorial = 2; 
        int p = 2;

        // We can only go up to about 14-15 iterations before long overflows
        for (int n = 1; n < 15; n++) { 
            long m = 2;
            while (true) {
                long candidate = primorial + m;
                // Use your checkPrime function here
                if (checkPrimeLong(candidate)) {
                    if (m < max) fortunate[(int)m] = true;
                    break; 
                }
                m++;
            }
            
            // Find next prime manually to multiply
            int nextP = p + 1;
            while(!checkPrimeLong(nextP)) nextP++;
            
            // Overflow check: if primorial * nextP exceeds Long.MAX_VALUE
            if (Long.MAX_VALUE / nextP < primorial) break;
            
            p = nextP;
            primorial *= p;
        }
    }

    private static boolean checkPrimeLong(long n){
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        for(long i = 5; i * i <= n; i += 6){
            if(n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }


    static int getSteps(int start){
    	Set<Integer> set = new HashSet<>();
    	int curr = start;
    	set.add(curr);
    	for(int i=1;i<=5000;i++){
    		int nxt = curr-i;
    		if(nxt>0 && !set.contains(nxt)){
    			curr=nxt;
    		} else {
    			curr=curr+i;
    		}

    		if(curr>1000000 || set.contains(curr)) return i;
    		set.add(curr);
    	}
    	return 5000;
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

// input 1
// 10
// 7373
// 5968
// 3638
// 47
// 6985
// 8219
// 59
// 8319
// 9100
// 9750
// 6
// 0 6 8951
// 1 1 7
// 1 2 5
// 1 6 8
// 0 4 2190
// 1 2 6

// output 1
// 1233


// 10
// 1308
// 398
// 8265
// 5321
// 9564
// 4620
// 9238
// 3740
// 1550
// 8924
// 10
// 1 0 0
// 0 1 3988
// 1 6 8
// 1 8 9
// 1 5 9
// 1 0 7
// 1 7 8
// 1 3 4
// 1 4 6
// 0 7 8327