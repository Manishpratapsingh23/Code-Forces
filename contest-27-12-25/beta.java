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

    private static void solve_kro(Scanner sc){
        String st = sc.next();
        StringBuilder sb = new StringBuilder(st);
        int s = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<st.length();i++){
            char ch = st.charAt(i);
            if(ch=='s'){
                set.add(i);
                s++;
            }
        }
        if(s==st.length()){
            System.out.println(0);
            return;
        }
        int last = 0;
        int ans = 0;
        if(st.charAt(0)=='u'){
            sb.setCharAt(0, 's');
            ans++;
            set.add(0);
        }
        int l = st.length();
        if(st.charAt(l-1)=='u'){
            sb.setCharAt(l-1, 's');
            ans++;
            set.add(l-1);
        }
        for(int i=0;i<st.length();i++){
            if(sb.charAt(i)=='s'){
                last = i;
            } else {
                int targetS = i + (i - last);
                    
                    if (targetS < l) {
                        if (!set.contains(targetS)) {
                            sb.setCharAt(targetS, 's');
                            set.add(targetS);
                            ans++;
                        }
                    } else {
                        sb.setCharAt(i, 's');
                        set.add(i);
                        last = i;
                        ans++;
                    }
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