import java.util.Scanner;
public class beta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
       
    }

    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();
        long arr[] = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextLong();
        }
        long max = arr[0];
        for(int i=1;i<n;i++){
            max = Math.max(max, arr[i]);
            if(i%2!=0) arr[i] = max;
        }
        long ans = 0;
        for(int i=1;i<n;i+=2){
            if(arr[i-1]>=arr[i]){
                ans += arr[i-1]-arr[i]+1;
                arr[i-1] = arr[i]-1;
            }
            if(i+1<n && arr[i]<=arr[i+1]){
                ans += arr[i+1]-arr[i]+1;
                arr[i+1]  = arr[i]-1;
            }
        }
        System.out.println(ans);
    }
}
