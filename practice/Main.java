import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        
        String line = br.readLine();
        if (line == null) return;
        int T = Integer.parseInt(line.trim());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().trim().split("\\s+");
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(arr_A[i]);
            }
            long K = Long.parseLong(br.readLine().trim());

            wr.println(solve(N, A, K));
        }
        wr.close();
        br.close();
    }

    static long solve(int N, int[] A, long K) {
        if (N < 3) return 0;

        long low = 1;
        // Max possible height is max(A) + K, but 2e9 is a safe upper bound
        long high = 2000000000L; 
        long result = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(mid, N, A, K)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static boolean isPossible(long H, int N, int[] A, long K) {
        // We only need ONE position to satisfy the condition within budget K
        for (int i = 1; i <= N - 2; i++) {
            long currentCost = Math.abs((long)A[i] - H);
            
            // Neighbor constraints: neighbors must be strictly less than H
            // To minimize cost, we only adjust them if they are >= H
            long leftNeighborCost = Math.max(0L, (long)A[i-1] - (H - 1));
            long rightNeighborCost = Math.max(0L, (long)A[i+1] - (H - 1));
            
            if (currentCost + leftNeighborCost + rightNeighborCost <= K) {
                return true;
            }
        }
        return false;
    }
}