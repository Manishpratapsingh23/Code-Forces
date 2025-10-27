import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    // Prime Factors TC: O(underoot N)
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
    // TC: n*log(long(n))
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


    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();
        int q = sc.nextInt();
        String s = sc.next();
        boolean hasB = s.indexOf('B') != -1;
        while(q-- > 0){
            int ans = 0;
            long a = sc.nextLong();
            if(!hasB){
                System.out.println(a);
                continue;
            }
            int i = 0;
            while(a!=0){
                if(s.charAt(i)=='A') a-=1;
                else a = (long)Math.floor(a/2);
                i = (i+1)%n;
                ans++;
            }
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }

    //    int prime[] = SieveEratosthenes(10);
    //    for(int i=2;i<prime.length;i++){
    //     if(prime[i]==1) System.err.print(i+" ");
    //   }
    }
}
