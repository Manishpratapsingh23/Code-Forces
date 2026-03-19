import java.util.*;

public class ThreeAcivity {

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

    private static int[] getMax(long arr[]){
    	int m1=-1,m2=-1,m3=-1;
    	for(int i=0;i<arr.length;i++){
    		if(m1==-1 || arr[i]>arr[m1]){
    			m3=m2;
    			m2=m1;
    			m1=i;
    		} else if(m2==-1 || arr[i]>arr[m2]){
    			m3=m2;
    			m2=i;
    		} else if(m3==-1 || arr[i]>arr[m3]){
    			m3=i;
    		}
    	}
    	return new int[]{m1,m2,m3};
    }
    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();

        long a[] = new long[n];
        long b[] = new long[n];
        long c[] = new long[n];


        for(int i=0;i<n;i++) a[i] = sc.nextLong();
        for(int i=0;i<n;i++) b[i] = sc.nextLong();
        for(int i=0;i<n;i++) c[i] = sc.nextLong();

        int aa[] = getMax(a);
        int bb[] = getMax(b);
        int cc[] = getMax(c);

        long sum = 0;

        for(int i : aa){
        	for(int j : bb){
        		for(int k : cc){
        			if(i!=j && j!=k && k!=i){
        				sum = Math.max(sum, a[i]+b[j]+c[k]);
        			}
        		}
        	}
        }
     
        System.out.println(sum);



    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve_kro(sc);
        }
    }
}

import java.util.*;

public class RoofConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Read the number of test cases
        while (t-- > 0) {
            long n = scanner.nextLong(); // Read the number of pillars
            n--; // Decrement n to work with zero-based index
            long msb = (long) (Math.log(n) / Math.log(2)); // Find the most significant bit position of n
            List<Long> ans = new ArrayList<>(); // List to store the sequence of pillar heights
            long num = (long) Math.pow(2, msb) - 1; // Calculate the largest number with all bits set below msb
            while (num >= 0) { // Fill the list with numbers from num to 0
                ans.add(num);
                num--;
            }
            num = (long) Math.pow(2, msb); // Start from the next power of 2
            while (num <= n) { // Fill the list with numbers from num to n
                ans.add(num);
                num++;
            }

            for (long height : ans) { // Output the sequence of pillar heights
                System.out.print(height + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}

// Time Complexity (TC): O(n) = O(2*10^5)
// Space Complexity (SC): O(n) = O(2*10^5)
