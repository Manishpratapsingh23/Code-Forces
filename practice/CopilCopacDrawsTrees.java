import java.io.*;
import java.util.*;

public class CopilCopacDrawsTrees {

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
    static Map<Integer, List<Integer>> map;
    static Map<String, Integer> rank;
    static int parent[];
    static boolean[] visited;
    private static void solve_kro(FastScanner sc) throws Exception{
    	int n = sc.nextInt();
    	visited = new boolean[n+1];
        parent = new int[n+1];
        rank = new HashMap<>();
        map = new HashMap<>();
        for(int i=1;i<=n;i++) map.put(i, new ArrayList<>());
    	Arrays.fill(visited, false);
    	for(int i=1;i<n;i++){
            int src = sc.nextInt();
            int des = sc.nextInt();
            map.get(src).add(des);
            map.get(des).add(src);
            rank.put(src+" "+des, i);
            rank.put(des+" "+src, i);
        }
        parent[0]=-1;
        parent[1]=0;
        Arrays.fill(visited, false);
        visited[1]=true;
        int dp[] = new int[n+1];
        dp[1]=1;
        int ans = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int node = queue.remove();
            for(int nbrs : map.get(node)){
                if(visited[nbrs]) continue;
                visited[nbrs]=true;
                parent[nbrs]=node;
                String key  = parent[node]+" "+node;
                String child = node+" "+nbrs;
                if(parent[node]!=0){
                    if(rank.get(child)<rank.get(key)){
                        dp[nbrs]=dp[node]+1;
                    } else dp[nbrs]=dp[node];
                } else dp[nbrs]=1;
                ans = Math.max(ans, dp[nbrs]);
                queue.add(nbrs);
            }
        }
        // for(int i : parent){
        //     System.out.print(i+" ");
        // }
        // System.out.println();
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