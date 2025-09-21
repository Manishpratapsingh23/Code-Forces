import java.util.Scanner;

public class OddSelection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            solve(sc);
        }
    }

    private static void solve(Scanner sc){
        int n = sc.nextInt();
        int x = sc.nextInt();
        int arr[] = new int[n];
        int count[] = new int[2];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            count[arr[i]%2]++;
        }
        boolean ans = false;
        for(int i=1;i<=count[1] && i<=x;i+=2){
            int needed = x-i;
            if(needed<=count[0]){
                ans = true;
                break;
            }
        }
        System.out.println(ans ? "Yes" : "No");
    }
}
