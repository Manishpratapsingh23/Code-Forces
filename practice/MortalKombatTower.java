import java.util.*;

public class MortalKombatTower {

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
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
        	arr[i] = sc.nextInt();
        }

        int ans = 0;
        if(arr[0]==1) ans++;
        int start=0;
        if(n>1) start = arr[1];
        int prev = 1;
        for(int i=1;i<n;i++){
        	if(arr[i]==start) continue;
        	else {
        		int segement = i-prev;
        		prev = i;
        		if(start==1) ans+= Math.floor(segement/3);
        		start = arr[i];
        	}
        }
        if(start==1){
        	int segement = n-prev;
        	ans+=Math.floor(segement/3);
        }
        System.out.println(ans);
    }

    private static void solve(Scanner sc){
        int n = sc.nextInt();
        int arr[] = new int[n+1];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int dp[][] = new int[n+1][2];
        dp[n][0]=0;
        dp[n][1]=0;
        dp[n-1][0]=0;
        dp[n-1][1]=arr[n-1];

        for(int i=n-2;i>=0;i--){
            dp[i][0] = Math.min(dp[i+1][1], dp[i+2][1]);
            dp[i][1] = Math.min(dp[i+1][0]+arr[i], dp[i+2][0]+arr[i]+arr[i+1]);
        }

        System.out.println(dp[0][1]);
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve(sc);
        }
    }
}