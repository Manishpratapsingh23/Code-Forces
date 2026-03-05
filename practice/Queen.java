import java.util.*;

public class Queen {

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
    static class Node{
    	int data;
    	//int parent;
    	int respect;
    	List<Node> children;
    	public Node(int data, int respect){
    		this.data=data;
    		//this.parent = parent;
    		this.respect=respect;
    		children = new ArrayList<>();
    	}
    }
    static List<Integer> lst;
    private static void solve_kro(Scanner sc){
        lst = new ArrayList<>();
        int n = sc.nextInt();
        Node[] tree = new Node[n+1];
        for(int i=0;i<=n;i++) tree[i] = new Node(-1,0);
        int top = -1;
        for(int i=1;i<=n;i++){
        	int parent = sc.nextInt();
        	int respect = sc.nextInt();
        	if(parent==-1){
        		top = i;
        	}
        	//tree[i] = new Node(i, parent, respect);
            tree[i].data=i;
            //tree[i].parent=parent;
            tree[i].respect=respect;
        	if(parent!=-1) tree[parent].children.add(tree[i]);
        }
        //tree[top].data=1;
        //print(tree[top]);

        dfs(tree[top]);
        if(lst.size()==0){
            System.out.println(-1);
            return;
        }
        Collections.sort(lst);
        for(int i : lst){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static boolean dfs(Node root){
        if(root.children.size()==0){
            if(root.respect==1){
                lst.add(root.data);
            }
            return root.respect==0;
        }

        boolean childRespect = false;
        for(Node child : root.children){
            childRespect |= dfs(child);
        }

        if(!childRespect && root.respect==1){
            lst.add(root.data);
        }

        return root.respect==0;
    }

    // private static void print(Node root){
    // 	if(root.children.size()==0){
    //         System.out.println(root.data+" "+root.parent+" "+root.respect);
    //         return;
    //     }

    // 	System.out.println(root.data+" "+root.parent+" "+root.respect);
    // 	for(Node child : root.children){
    // 		print(child);
    // 	}
    // }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int test = sc.nextInt();
        //while (test-- > 0) {
            solve_kro(sc);
        //}
    }
}