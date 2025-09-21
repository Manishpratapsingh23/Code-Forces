import java.util.*;

public class alpha1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) solve(sc);
       
    }
    private static void solve(Scanner sc){
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int freq[] = new int[51];
        for(int i : arr) freq[i]++;
        int ans = 0;
        int r = Math.min(freq[0],freq[1]);
        ans += 2*r;
        freq[0] -= r;
        freq[1] -= r;
        ans += freq[0];
        freq[0] = 0;
        for(int i=0;i<=50;i++){
            if(freq[i]>0) ans+=freq[i]*i;
        }
        System.out.println(ans);
    }
}