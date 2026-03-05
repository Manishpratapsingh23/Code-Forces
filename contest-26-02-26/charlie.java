import java.util.*;

public class charlie {

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
        Node prev;
        Node next;
        public Node(int data){
            this.data = data;
            prev = null;
            next=null;
        }
    }

    static Map<Integer, Node> map;
    //static Set<Integer> set;
    private static void solve_kro(Scanner sc){
        //map = new HashMap<>();
        //set = new HashSet<>();
        int n = sc.nextInt();
        List<int[]> lst = new ArrayList<>();
        for(int i=0;i<n;i++){
            int l = sc.nextInt();
            int arr[] = new int[l];
            for(int j=0;j<l;j++) arr[j] = sc.nextInt();
            lst.add(arr);
        }

        Collections.sort(lst, (a, b) -> {
            int i = a.length - 1;
            int j = b.length - 1;
            while(i >= 0 && j >= 0) {
                if(a[i] != b[j]) {
                    return b[j] - a[i];
                }
                i--;
                j--;
            }
            return b.length - a.length;
        });
        // System.out.println("########################################");
        // for(int arr[] : lst){
        //     for(int i : arr){
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("########################################");
        String s1 = compute(n,lst);
        System.out.println(s1);
    
    }

    public static String compute(int n, List<int[]> lst){
        map = new HashMap<>();
        Node head = null;
        for(int arr[] : lst){
            head = solve(arr, head);
        }
        StringBuilder sb = new StringBuilder();
        while(head!=null){
            sb.append(head.data).append(" ");
            head=head.next;
        }
        //System.out.println();
        return sb.toString();
    }

    private static Node solve(int arr[], Node head){
         for(int i : arr){
            if(map.containsKey(i)){
                Node curr = map.get(i);
                if(curr==head) continue;
                if(curr.prev!=null){
                    curr.prev.next=curr.next;
                }

                if(curr.next!=null){
                    curr.next.prev=curr.prev;
                }
                curr.prev=null;
                curr.next=head;
                if(head!=null) head.prev=curr;
                head=curr;
            } else {
                Node node = new Node(i);
                if(head!=null){
                    node.next=head;
                    head.prev=node;
                    head = node;
            } else {
                head = node;
            }
                //set.add(i);
                map.put(i,node);
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve_kro(sc);
        }
    }
}