import java.util.*;

public class VikaAndBridge {

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
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        List<List<Integer>> lst = new ArrayList<>();
        for(int i=0;i<=k;i++){
        	lst.add(new ArrayList<>());
        	lst.get(i).add(0);
        }
        for(int i=0;i<n;i++){
        	lst.get(arr[i]).add(i+1);
        }
        for(int i=1;i<=k;i++){
        	lst.get(i).add(n+1);
        }

        PriorityQueue<Integer>[] cc = new PriorityQueue[k+1];
        for(int i=0;i<=k;i++){
        	cc[i]=new PriorityQueue<>(Collections.reverseOrder());
        }

        int ans = Integer.MAX_VALUE;

        for(int i=1;i<=k;i++){
        	for(int j=0;j<lst.get(i).size()-1;j++){
        		cc[i].add(lst.get(i).get(j+1)-lst.get(i).get(j)-1);
        	}

        	int top = cc[i].poll();
        	if(top%2==0){
        		cc[i].add((top/2)-1);
        	} else cc[i].add(top/2);
        	cc[i].add(top/2);

        	ans = Math.min(ans, cc[i].peek());
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