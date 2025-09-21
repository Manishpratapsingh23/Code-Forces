import java.util.*;

public class alpha {
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

        int sum = 0;
        int zero_freq = 0;
        int one_freq = 0;
        for(int i : arr) {
            sum+=i;
            if(i==0) zero_freq++;
            if(i==1) one_freq++;
        }

        int mex = 0;
        if(zero_freq!=0){
            if(one_freq>0) mex = 2;
        }
        if(mex==2) sum+=mex-1;
        System.out.println(sum);
    }
}