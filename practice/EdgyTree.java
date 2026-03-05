import java.util.*;

public class EdgyTree {

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
    static int cnt;
    static Map<Integer, List<Integer>> map;
    static int visted[];
    static int mod = 1000000007;
	
    private static void solve_kro(Scanner sc){
        map = new HashMap<>();
        int n = sc.nextInt();
        visted = new int[n+1];
        Arrays.fill(visted,-1);
        int k = sc.nextInt();
        for(int i=1;i<=n;i++) map.put(i, new ArrayList<>());
        for(int i=1;i<n;i++){
        	int src = sc.nextInt();
        	int des = sc.nextInt();
        	int cc = sc.nextInt();
        	if(cc==0){
        		map.get(src).add(des);
        		map.get(des).add(src);
        	}
        }

        long ans = 0L;
        for(int i=1;i<=n;i++){
        	if(visted[i]!=-1) continue;
        	cnt = 0;
        	dfs(i);
        	ans = (ans+fastPow(cnt,k))%mod;
        }

        ans = (fastPow(n,k)-ans+mod)%mod;
        System.out.println(ans);
    }

    public static long fastPow(long a, long b){
    	a %= mod;
	    long result = 1;

	    while(b > 0){
	        if((b & 1) == 1)
	            result = (result * a) % mod;
	        a = (a * a) % mod;
	        b >>= 1;
	    }
    	return result;
    }

    private static void dfs(int src){
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(src);
    	visted[src]=1;
    	while(!queue.isEmpty()){
    		int node = queue.remove();
    		cnt++;
    		for(int nbrs : map.get(node)){
    			if(visted[nbrs]!=-1) continue;
    			visted[nbrs]=1;
    			queue.add(nbrs);
    		}
    	}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int test = sc.nextInt();
        //while (test-- > 0) {
            solve_kro(sc);
        //}
    }
}