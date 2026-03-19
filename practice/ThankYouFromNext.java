import java.io.*;
import java.util.*;

public class ThankYouFromNext {

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
    	int vtx;
    	int dist;
    	Node(int vtx, int dist){
    		this.vtx=vtx;
    		this.dist = dist;
    	}
    }

    static int maxEnergy[];
    static int n,m,k;
    static Map<Integer, List<Integer>> map;
    static PriorityQueue<Node> pq;
    private static void solve_kro(FastScanner sc) throws Exception{
    	n = sc.nextInt();
    	m = sc.nextInt();
    	k = sc.nextInt();
    	Queue<Integer> queue = new LinkedList<>();
    	for(int i=0;i<k;i++) queue.add(sc.nextInt());
        pq = new PriorityQueue<>((Node a, Node b)->(b.dist-a.dist));
        maxEnergy = new int[n+1];
        Arrays.fill(maxEnergy, -1);
    	for(int i=0;i<k;i++){
    		int vtx = queue.remove();
    		int dist = sc.nextInt()-1;
            if(dist>maxEnergy[vtx]){
                maxEnergy[vtx]=dist;
                pq.add(new Node(vtx, dist));
            }
    	}

    	map = new HashMap<>();
    	for(int i=1;i<=n;i++) map.put(i, new ArrayList<>());
    	for(int i=0;i<m;i++){
    		int s = sc.nextInt();
    		int d = sc.nextInt();
    		map.get(s).add(d);
    		map.get(d).add(s);
    	}
        
        dijkastra();

        for(int i=1;i<=n;i++){
        	if(maxEnergy[i]==-1){
        		System.out.println("No");
        		return;
        	}
        }
        System.out.println("Yes");
    }

    static void dijkastra(){
    	while(!pq.isEmpty()){
    		Node node = pq.remove();
            if(node.dist<maxEnergy[node.vtx]) continue;
            if(node.dist>0){
                for(int nbrs : map.get(node.vtx)){
                    if(node.dist-1<=maxEnergy[nbrs]) continue;
                    maxEnergy[nbrs]=node.dist-1;
                    pq.add(new Node(nbrs, maxEnergy[nbrs]));
                }
            }
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

