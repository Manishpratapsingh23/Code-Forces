import java.util.Scanner;

public class charlie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++) arr[i]=sc.nextInt();
            solve(n,arr);
        }
    }
    private static void solve(int n,int arr[]){
        if(n==1){
            System.out.println("1");
            return;
        }
        int prefix[] = new int[n];
        prefix[0] = arr[0];
        int suffix[] = new int[n];
        suffix[n-1] = arr[n-1];
        for(int i=1;i<n;i++) prefix[i] = Math.min(prefix[i-1],arr[i]);
        for(int i=n-2;i>=0;i--) suffix[i] = Math.max(suffix[i+1],arr[i]);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            int left_min = (i == 0) ? Integer.MAX_VALUE : prefix[i - 1];
            int right_max = (i == n - 1) ? Integer.MIN_VALUE : suffix[i + 1];

            if (arr[i] < left_min || arr[i] > right_max) {
                ans.append('1');
            } else {
                ans.append('0');
            }
        }

        System.out.println(ans);

    }
}