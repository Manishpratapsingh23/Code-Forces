import java.util.*;

public class beta {

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

    static long neg = Integer.MIN_VALUE;

    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();
        long a[] = new long[n];
        long b[] = new long[n];
        for(int i=0;i<n;i++) a[i]=sc.nextLong();
        for(int i=0;i<n;i++) b[i]=sc.nextLong();
        long memo[][] = new long[n][2];
        for (long[] arr : memo) Arrays.fill(arr, Long.MIN_VALUE);
        long ans = Math.max(helper(0,a,b,memo,0), helper(0,a,b,memo,1));
        System.out.println(ans);

    }

    private static long helper(int idx, long a[], long b[], long memo[][], int take){
    	if(idx==a.length) return take==0 ? 0:neg;
    	if(memo[idx][take]!=Long.MIN_VALUE) return memo[idx][take];
    	long ans = 0L;
    	if(take==0){
    		long op1 = helper(idx+1,a,b,memo,0)-a[idx];
    		long op2 = helper(idx+1,a,b,memo,1)-b[idx];
    		ans = Math.max(op1,op2);
    	} else {
    		long op1 = helper(idx+1,a,b,memo,1)+a[idx];
    		long op2 = helper(idx+1,a,b,memo,0)+b[idx];
    		ans = Math.max(op1,op2);
    	}
    	return memo[idx][take]=ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve_kro(sc);
        }
    }
}