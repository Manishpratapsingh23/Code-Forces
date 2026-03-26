import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    static int[] segment;
    static int[] remacanDist;
    static boolean[] fortunate;

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        
        // 1. Precompute
        compute();

        // 2. Read Array
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        
        segment = new int[4 * n];
        build(0, 0, n - 1, arr);

        // 3. Process Queries
        int q = sc.nextInt();
        long totalSum = 0;
        
        while (q-- > 0) {
            int type = sc.nextInt();
            if (type == 0) {
                int i = sc.nextInt(); // 0-based as per "1 0 0" example
                int x = sc.nextInt();
                update(0, 0, n - 1, i, x);
            } else {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int m = query(0, 0, n - 1, l, r);
                
                if (m != -1) {
                    int dist = (m < remacanDist.length) ? remacanDist[m] : getSteps(m);
                    int multiplier = (m < fortunate.length && fortunate[m]) ? 17 : 1;
                    totalSum += (long) dist * multiplier;
                }
            }
        }
        System.out.println(totalSum);
    }

    static void compute() {
        int max = 10001;
        remacanDist = new int[max];
        fortunate = new boolean[max];

        // Precompute Recaman distances for M values
        for (int i = 0; i < max; i++) {
            remacanDist[i] = getSteps(i);
        }

        // Calculate Fortunate numbers (smallest m > 1 for p# + m is prime)
        BigInteger primorial = BigInteger.valueOf(2);
        BigInteger p = BigInteger.valueOf(2);
        for (int i = 0; i < 100; i++) {
            int m = 2;
            while (true) {
                if (primorial.add(BigInteger.valueOf(m)).isProbablePrime(10)) {
                    if (m < max) fortunate[m] = true;
                    break;
                }
                m++;
            }
            p = p.nextProbablePrime();
            primorial = primorial.multiply(p);
            if (primorial.bitLength() > 500) break; 
        }
    }

    static int getSteps(int m) {
        if (m > 1000000) return 0;
        
        Set<Integer> visited = new HashSet<>();
        int curr = m;
        visited.add(curr);
        
        for (int n = 1; n <= 5000; n++) {
            int backward = curr - n;
            int next;
            
            // Note: "Positive" strictly means > 0
            if (backward > 0 && !visited.contains(backward)) {
                next = backward;
            } else {
                next = curr + n;
            }
            
            // Stop if exceeds 10^6 or revisits a value
            if (next > 1000000 || visited.contains(next)) {
                return n;
            }
            
            visited.add(next);
            curr = next;
        }
        return 5000;
    }

    // --- Segment Tree ---
    static void build(int idx, int start, int end, int arr[]) {
        if (start == end) {
            segment[idx] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(2 * idx + 1, start, mid, arr);
        build(2 * idx + 2, mid + 1, end, arr);
        segment[idx] = Math.max(segment[2 * idx + 1], segment[2 * idx + 2]);
    }

    static void update(int idx, int start, int end, int i, int val) {
        if (start == end) {
            segment[idx] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (i <= mid) update(2 * idx + 1, start, mid, i, val);
        else update(2 * idx + 2, mid + 1, end, i, val);
        segment[idx] = Math.max(segment[2 * idx + 1], segment[2 * idx + 2]);
    }

    static int query(int idx, int start, int end, int l, int r) {
        if (start > r || end < l) return -1;
        if (start >= l && end <= r) return segment[idx];
        int mid = (start + end) / 2;
        return Math.max(query(2 * idx + 1, start, mid, l, r), query(2 * idx + 2, mid + 1, end, l, r));
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws Exception {
            while (st == null || !st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws Exception { return Integer.parseInt(next()); }
    }
}