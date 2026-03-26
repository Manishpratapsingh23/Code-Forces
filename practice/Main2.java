import java.io.*;
import java.util.*;

public class Main2 {
    static long solve(int N, int K, long[] A) {
        Map<Long, Long> freq = new HashMap<>();
        for (long x : A) freq.merge(x, 1L, Long::sum);
        
        long[] vals = freq.keySet().stream().mapToLong(x -> x).sorted().toArray();
        int M = vals.length;
        
        Map<Long, Integer> idx = new HashMap<>();
        for (int i = 0; i < M; i++) idx.put(vals[i], i);
        
        long result = 0;
        
        // Standard progressions: base b >= 2
        for (int bi = 0; bi < M; bi++) {
            long b = vals[bi];
            if (b < 2) continue;
            long power = b;
            for (int step = 2; step <= K + 1; step++) {
                if (power > (long)1e18 / b) break;
                power *= b;
                if (power > (long)1e18) break;
                Integer found = idx.get(power);
                if (found == null) break;
                // score = freq(b) + freq(p) only
                long score = freq.get(b) + freq.get(power);
                result = Math.max(result, score);
            }
        }
        
        // Perfect square progressions: vals[i] = x^2, x >= 2
        for (int i = 0; i < M; i++) {
            long val = vals[i];
            long x = (long) Math.round(Math.sqrt((double)val));
            if (x < 2 || x * x != val) continue;
            long x2 = x * x;
            long curVal = val;
            for (int step = 1; step <= K; step++) {
                if (curVal > (long)1e18 / x2) break;
                long nextVal = curVal * x2;
                if (nextVal > (long)1e18) break;
                Integer found = idx.get(nextVal);
                if (found == null) break;
                long score = freq.get(val) + freq.get(nextVal);
                result = Math.max(result, score);
                curVal = nextVal;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());
        String[] arr_A = br.readLine().split(" ");
        long[] A = new long[N];
        for (int i = 0; i < N; i++) A[i] = Long.parseLong(arr_A[i]);
        long out_ = solve(N, K, A);
        System.out.println(out_);
        wr.close();
        br.close();
    }
}