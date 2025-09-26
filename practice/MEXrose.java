
import java.util.Scanner;
public class MEXrose {
    
// }
// import java.util.Arrays;
// import java.util.Scanner;
// public class UnconventionalPairs{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0)  solve(sc);
    }

    private static void solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n+1];
        //int negative = 0, zero = 0;
        for(int i=0;i<n;i++){
           int x = sc.nextInt();
           arr[x]++;
        }
        int notPresent = 0;
        for(int i=0;i<k;i++){
            if(arr[i]==0) notPresent++;
        }
        System.out.println(Math.max(notPresent, arr[k]));
    }
}