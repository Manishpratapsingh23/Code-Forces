import java.io.*;
import java.util.*;

public class EasySegementTree {
	static class Node{
		int x,y,i;
        long sum;
		Node(int x, int y, int i, long sum){
			this.x=x;
			this.y=y;
			this.i=i;
			this.sum=sum;
		}
	}

	static Node[] segement[];
    static int l,r,x,y;
    private static void solve_kro(FastScanner sc) throws Exception{
    	int n = sc.nextInt();
        segement = new Node[4*n];
        long arr[] = new long[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextLong();
        build(0,0,n-1,arr);

        int q = sc.nextInt();
        while(q-->0){
            this.l = sc.nextInt();
            this.r = sc.nextInt();
            this.x = sc.nextInt();
            this.y = sc.nextInt();
            long ans = update(0,0,n-1);
        }
        
    }

    static long update(int idx,int start, int end){
        if(start>r || end<l) return 0L;
        if(start>=l && end<=r) return segement[idx].sum;
        
    }

    static void build(int idx, int start, int end, long arr[]){
        if(start==end){
            Node node = new Node(arr[start],0,0,arr[start]);
            segement[idx]=node;
            return;
        }
        int mid = start+(end-start)/2;
        build(2*idx+1, start, mid, arr);
        build(2*idx+2, mid+1, end, arr);
        long sum = (segement[2*idx+1].sum+segement[2*idx+2])%mod;
        Node node = new Node(sum,0,0,sum);
        segement[idx]=node;
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