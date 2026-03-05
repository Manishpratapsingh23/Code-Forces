import java.util.*;

public class DivisiblePairs {

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

    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int arr[] = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
        	arr[i] = sc.nextInt();
        	int r = arr[i]%y;
        	map.putIfAbsent(r, new ArrayList<>());
            map.get(r).add(arr[i]);
        }

        long ans = 0;
        for(List<Integer> val : map.values()){
        	Map<Integer, Long> map1 = new HashMap<>();
        	for(int v : val){
        		int r = v%x;
        		map1.put(r, map1.getOrDefault(r,0L)+1);
        	}

        	Set<Integer> set = new HashSet<>();
        	for(int r : map1.keySet()){
        		long cnt = map1.get(r);
        		if(set.contains(r)) continue;
        		if(r==0 || (x%2==0 && r==x/2)){
        			ans += (cnt*(cnt-1))/2;
        		} else {
        			long cnt1 = map1.getOrDefault(x-r,0L);
        			ans+=cnt*cnt1;
        			set.add(x-r);
        		}
        		set.add(r);
        	}
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve_kro(sc);
        }
    }
}