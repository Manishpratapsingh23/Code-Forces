import java.util.*;

public class MergingTheSets {

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
        int m = sc.nextInt();

        int[] cnt = new int[m];
        int t = 0;

        List<List<Integer>> v = new ArrayList<>();

        // Read input
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < l; j++) {
                int x = sc.nextInt() - 1;

                if (cnt[x] == 0) t++;
                cnt[x]++;

                temp.add(x);
            }
            v.add(temp);
        }

        int ans = (t == m) ? 1 : 0;

        // Sliding removal logic
        for (int i = 0; i < n; i++) {
            for (int x : v.get(i)) {
                cnt[x]--;
                if (cnt[x] == 0) t--;
            }

            if (t == m) ans++;

            for (int x : v.get(i)) {
                if (cnt[x] == 0) t++;
                cnt[x]++;
            }
        }

        System.out.println(ans >= 3 ? "YES" : "NO");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve_kro(sc);
        }
    }
}