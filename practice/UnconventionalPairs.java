import java.util.Arrays;
import java.util.Scanner;
public class UnconventionalPairs{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0)  solve(sc);
    }

    private static void solve(Scanner sc){
        int n = sc.nextInt();
        int arr[] = new int[n];
        //int negative = 0, zero = 0;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        // int ans = 0;
        // ans+=zero;
        // if(negative%2==1) ans+=2;
        // System.out.println(ans);
        int ans = 0;
        Arrays.sort(arr);
        for(int i=0;i<n;i+=2){
            ans = Math.max(ans, Math.abs(arr[i]-arr[i+1]));
        }
        System.out.println(ans);
    }
}