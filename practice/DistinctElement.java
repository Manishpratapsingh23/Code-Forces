import java.util.Scanner;

public class DistinctElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0)  solve(sc);
    }

    private static void solve(Scanner sc){
        int n = sc.nextInt();
        
        long b[] = new long[n];
        
        for(int i=0;i<n;i++) b[i] = sc.nextLong();
        //int notPresent = 0;
        long ans[] = new long[n];
        ans[0] = 1;
        long diff = 2;
        long x = 1;
        for(int i=1;i<n;i++){
            if(b[i-1]+diff==b[i]) ans[i] = ++x;
            else {
                int idx = (int)(b[i]-b[i-1]);
                ans[i] = ans[i-idx];
            }
            diff++;
        }
        for(long i : ans) System.out.print(i+" ");
        System.out.println();

    }
}
