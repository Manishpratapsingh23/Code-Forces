import java.io.*;
import java.util.*;

public class InversionCount {
    static long segement[];
    private static void solve_kro(FastScanner sc) throws Exception{
    	int n = sc.nextInt();
    	int arr[] = new int[n];
        int mx = 0;
    	for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            mx = Math.max(mx, arr[i]);
        }
        int freq[] = new int[mx+1];
        for(int i : arr) freq[i]++;
        segement = new long[4*n];
        build(0,0,mx,freq);
    	long cnt = 0;
        for(int i=0;i<n;i++){
            freq[arr[i]]--;
            update(0,0,mx,arr[i],-1);
            cnt+=query(0,0,mx,1,arr[i]);
        }
        System.out.println(cnt);
    }

    static void build(int idx, int start, int end, int freq[]){
        if(start==end){
            segement[idx]=freq[start];
            return;
        }
        int mid = start+(end-start)/2;
        build(2*idx+1, start, mid, freq);
        build(2*idx+2, mid+1, end, freq);
        segement[idx]=segement[2*idx+1]+segement[2*idx+2];
    }

    static long query(int idx, int start, int end, int l, int r){
        if(r<start || l>end)  return 0L;
        if(start>=l && end<=r) return segement[idx];
        int mid = start+(end-start)/2;
        long left = query(2*idx+1, start, mid, l, r);
        long right = query(2*idx+2, mid+1, end, l, r);
        return left+right;
    }

    static void update(int idx, int start, int end, int i, int val){
        if(start==end){
            segement[idx]+=val;
            return;
        }
        int mid = start+(end-start)/2;
        if(i<=mid) update(2*idx+1, start, mid, i, val);
        else update(2*idx+2, mid+1, end, i, val);
        segement[idx]=segement[2*idx+1]+segement[2*idx+2];

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