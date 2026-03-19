import java.io.*;
import java.util.*;

public class charlie {

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

    private static long Lcm(long x, long y, long m) {
        if (x == 0 || y == 0) return 0;
        long gcd = GCD(x, y);
        if ((x / gcd) > (double) m / y) return m + 1; 
        return (x / gcd) * y;
    }

    private static long GCD(long a, long b){
        while(a>0 && b>0){
            if(a>b) a = a%b;
            else b = b%a;
        }
        if(a==0) return b;
        return a;
    }

    

    private static void solve_kro(FastScanner sc) throws Exception{
    	long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        long m = sc.nextLong();

        long aa = (m/a);
        long bb = (m/b);
        long cc = (m/c);


        long ab = Lcm(a, b, m);
        long bc = Lcm(b, c, m);
        long ca = Lcm(c, a, m);
        long abc = Lcm(ab, c, m);


        long t = m/abc;
        long p = m/ab-t;
        long q = m/bc-t;
        long r = m/ca-t;

        long x = aa-(p+r+t);
        long y = bb-(p+q+t);
        long z = cc-(q+r+t);


        long aaa = 6*x+3*(p+r)+2*t;
        long bbb = 6*y+3*(p+q)+2*t;
        long ccc = 6*z+3*(r+q)+2*t;

        System.out.println(aaa+" "+bbb+" "+ccc);
        
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