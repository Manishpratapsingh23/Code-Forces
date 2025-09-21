import java.util.Scanner;

public class beta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n=sc.nextInt();
            long arr[]=new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            finish(arr);
        }
    }


    private static void finish(long[] arr) {
        //throw new UnsupportedOperationException("Not supported yet.");
        int n=arr.length;
        long[] pm = new long[n]; 
        long[] ps = new long[n]; 
        pm[0] = arr[0];
        ps[0] = pm[0];
        for (int i = 1; i < n; i++) {
                pm[i] = Math.min(pm[i - 1], arr[i]);
                ps[i] = ps[i - 1] + pm[i];
        }
        long ans = ps[n - 1];
        final long INF = (long) 4e18;
        for (int i = 0; i < n - 1; i++) {
                long prevM = (i > 0) ? pm[i - 1] : INF;
                long prevS = (i > 0) ? ps[i - 1] : 0L;
                long comb = arr[i] + arr[i + 1];
                long take = Math.min(prevM, comb);
                ans = Math.min(ans, prevS + take);
            }

            System.out.println(ans);
    }
}
