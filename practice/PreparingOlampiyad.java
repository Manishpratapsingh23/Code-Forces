import java.util.*;

public class PreparingOlampiyad {

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
    	int l = sc.nextInt();
    	int r = sc.nextInt();
    	int x = sc.nextInt();
    	int c[] = new int[n];
    	for(int i=0;i<n;i++) c[i] = sc.nextInt();
    	int ans = Number_Way(n,c,l,r,x);
        System.out.println(ans);
    }


    private static int Number_Way(int n,int c[], int l, int r, int x){
        int ans = 0;
        for(int i=3;i<(1<<n);i++){
        	if(fast_Count_SetBit(i)>=2 && isitpossible(c,l,r,x,i)) ans++;
        }
        return ans;
    }

    private static boolean isitpossible(int c[], int l, int r, int x, int i){
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int idx = 0;
        while(i>0){
        	if((i&1)==1){
        		sum+=c[idx];
        		min = Math.min(min,c[idx]);
        		max = Math.max(max,c[idx]);
        	}
        	i >>= 1;
        	idx++;
        }
        int diff = max-min;
        boolean bb =  (diff>=x) && (sum>=l && sum<=r);
        //System.out.println(bb);
        return bb;
    }

    private static int fast_Count_SetBit(int n){
        int ans = 0;
        while(n>0){
        	ans++;
        	n = n&(n-1);
        }
        return ans;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int test = sc.nextInt();
        //while (test-- > 0) {
            solve_kro(sc);
        //}
    }
}