import java.util.Scanner;

public class beta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
           int n = sc.nextInt();
           int j = sc.nextInt();
           int k = sc.nextInt();
           int[] arr = new int[n];
           int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; ++i) {
                arr[i] = sc.nextInt();
                max=Math.max(max,arr[i]);
            }
            if(k>1){
                System.out.println("Yes");
            }
            else{
                if(arr[j-1]==max){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            }


        }
    }    
}