import java.util.*;

public class NewsDistribution {

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
    static int parent[];
    static int size[];
    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<=n;i++){
        	parent[i] = i;
        	size[i]=1;
        }

        int m = sc.nextInt();
        while(m-- > 0){
        	int k = sc.nextInt();
        	if(k==0) continue;
        	int src = sc.nextInt();
        	for(int i=1;i<k;i++){
        		int des = sc.nextInt();
        		union(src,des);
        	}
        }

        for(int i=1;i<=n;i++){
        	parent[i]=findParent(i);
        }
        for(int i=1;i<=n;i++){
        	System.out.print(size[parent[i]]+" ");
        }
        System.out.println();
    }

    private static void union(int src, int des){
    	int psrc = findParent(src);
    	int pdes = findParent(des);
    	if(psrc==pdes) return;
    	if(size[psrc]<size[pdes]){
    		int t = psrc;
    		psrc = pdes;
    		pdes = t;
    	}
    	parent[pdes]=psrc;
    	size[psrc]+=size[pdes];
    }

    private static int findParent(int src){
    	while(parent[src]!=src){
    		parent[src] = parent[parent[src]];
    		src = parent[src];
    	}
    	return src;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int test = sc.nextInt();
        //while (test-- > 0) {
            solve_kro(sc);
        //}
    }
}