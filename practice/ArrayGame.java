import java.util.*;

public class ArrayGame {

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
        long k = sc.nextLong();

        long arr[] = new long[n];

        for(int i=0;i<n;i++){
        	arr[i] = sc.nextLong();
        }

        if(k>=3){
        	System.out.println(0);
        	return;
        }
        long diff = arr[0];
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
        	diff = Math.min(diff, arr[i+1]-arr[i]);
        }
        if(k==1){
        	System.out.println(diff);
        	return;
        }

        for(int i=0;i<n;i++){
        	for(int j=0;j<i;j++){
        		long v = arr[i]-arr[j];
        		int p = lowerBound(arr,v);
        		if(p<0) p=-(p+1);
        		if(p<n){
        			diff = Math.min(diff, arr[p]-v);
        		}
        		if(p>0){
        			diff=Math.min(diff,v-arr[p-1]);
        		}
        	}
        }
        System.out.println(diff);
    }

    public static int lowerBound(long[] a, long v) {
	    int low = 0;
	    int high = a.length;
	    while (low < high) {
	        int mid = low + (high - low) / 2;
	        if (a[mid] >= v) {
	            high = mid;
	        } else {
	            low = mid + 1;
	        }
	    }
	    return low;
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve_kro(sc);
        }
    }
}

