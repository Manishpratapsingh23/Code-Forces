import java.io.*;
import java.util.*;

public class XeniaAndBitOperations {

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
    	int data;
    	int start;
    	int end;
    	Node left;
    	Node right;
    	public Node(int data, int start, int end){
    		this.data=data;
    		this.start=start;
    		this.end=end;
    		left=null;
    		right=null;
    	}
    }

    static Node root;

    private static void solve_kro(FastScanner sc) throws Exception{
    	int n = sc.nextInt();
    	int q = sc.nextInt();
    	int ss = 1<<n;
    	int arr[] = new int[ss+1];
    	for(int i=1;i<=ss;i++) arr[i]=sc.nextInt();
    	boolean op = n%2==0 ? true : false;
    	root = build(1,ss,arr,op);

    	while(q-->0){
    		int idx = sc.nextInt();
    		int val = sc.nextInt();
    		solve(root,1,ss,idx,val,op);
    		System.out.println(root.data);
    	}
    }

    private static void solve(Node root, int start, int end, int idx, int val, boolean op){
    	if(start==end){
    		root.data=val;
    		return;
    	}

    	int mid = start+(end-start)/2;
    	if(idx<=mid){
    		solve(root.left, start, mid, idx, val, !op);
    	} else {
    		solve(root.right, mid+1, end, idx, val, !op);
    	}

    	if(op){
    		root.data = (root.left.data ^ root.right.data);
    	} else {
    		root.data = (root.left.data | root.right.data);
    	}

    }

    private static Node build(int start, int end, int arr[], boolean op){
    	if(start==end){
    		Node node = new Node(arr[start], start,end);
    		return node;
    	}
    	int mid = start+(end-start)/2;
    	Node left = build(start,mid,arr,!op);
    	Node right = build(mid+1,end,arr,!op);
    	Node node = new Node(0,start,end);
    	if(op){
    		node.data = (left.data ^ right.data);
    	} else {
    		node.data = (left.data | right.data);
    	}
    	node.left=left;
    	node.right=right;
    	return node;
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