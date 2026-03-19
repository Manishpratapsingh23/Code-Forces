import java.io.*;
import java.util.*;

public class SerejaAndBrackets {

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

    static class Node{
    	int start;
    	int end;
    	int open;
    	int close;
    	int full;
    	Node left;
    	Node right;
    	public Node(int start, int end, int open, int close, int full){
    		this.open=open;
    		this.close=close;
    		this.start=start;
    		this.end=end;
    		this.full=full;
    		left=null;
    		right=null;
    	}
    }
    static Node root;
    private static void solve_kro(FastScanner sc) throws Exception{
    	String s = sc.next();
    	root = build(s,0,s.length()-1);

    	int q = sc.nextInt();
    	while(q-- > 0){
    		int l = sc.nextInt()-1;
    		int r = sc.nextInt()-1;
    		Node ans = helper(root,l,r);
    		System.out.println(2*ans.full);
    	}
        
    }

    static Node helper(Node root, int l, int r){
        int start = root.start;
        int end = root.end;
    	if(start>r || end<l){
            return new Node(0,0,0,0,0);
        }
    	if(start>=l && end<=r) return root;
    	
    	int mid = start+(end-start)/2;
    	Node left = helper(root.left, l, r);
    	Node right = helper(root.right, l, r);
    	return merge(start,end,left,right);
    }

    static Node merge(int start, int end, Node left, Node right){
        Node node = new Node(0,0,0,0,0);
        node.start=start;
        node.end=end;
        int full = Math.min(left.open, right.close);
        node.open = left.open+right.open-full;
        node.close = left.close+right.close-full;
        node.full=full+left.full+right.full;
        node.left=left;
        node.right=right;
        return node;

    }

    static Node build(String s, int start, int end){
    	if(start==end){
    		Node node = new Node(start,end,0,0,0);
    		if(s.charAt(start)=='(') node.open = 1;
    		else node.close = 1;
    		return node;
    	}
    	int mid = start+(end-start)/2;
    	Node left = build(s,start,mid);
    	Node right = build(s,mid+1,end);
    	return merge(start,end,left,right);
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