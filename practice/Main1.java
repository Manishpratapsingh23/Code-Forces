import java.io.*;
import java.util.*;

public class Main1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Handling input N and K
        String line1 = br.readLine();
        if (line1 == null) return;
        String[] nk = line1.trim().split("\\s+");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);

        long[] A = new long[N];
        String[] arr = br.readLine().trim().split("\\s+");
        for (int i = 0; i < N; i++) A[i] = Long.parseLong(arr[i]);

        Arrays.sort(A);
        
        // Frequency and Unique elements
        TreeMap<Long, Integer> freq = new TreeMap<>();
        for (long x : A) freq.put(x, freq.getOrDefault(x, 0) + 1);
        
        long[] unique = new long[freq.size()];
        long[] prefixFreq = new long[freq.size()];
        int idx = 0;
        long cumulative = 0;
        for (Map.Entry<Long, Integer> entry : freq.entrySet()) {
            unique[idx] = entry.getKey();
            cumulative += entry.getValue();
            prefixFreq[idx] = cumulative;
            idx++;
        }

        long maxScore = 0;
        long LIMIT = 1_000_000_000_000_000_000L;

        // 1. Standard Progressions (b^1, b^2, ...)
        for (long b : unique) {
            if (b <= 1) continue;
            long curr = b;
            for (int p = 1; p <= K; p++) {
                if (LIMIT / b < curr) break; // Overflow check
                curr *= b;
                if (freq.containsKey(curr)) {
                    maxScore = Math.max(maxScore, getRangeCount(b, curr, unique, prefixFreq));
                } else {
                    break; // All intermediate terms must exist
                }
            }
        }

        // 2. Perfect Square Progressions (b, b*s, b*s^2, ...)
        // Group by square-free part to find b and b*r^2
        Map<Long, List<Long>> groups = new HashMap<>();
        for (long x : unique) {
            long[] parts = getSquareFreeParts(x);
            groups.computeIfAbsent(parts[0], k -> new ArrayList<>()).add(parts[1]);
        }

        for (List<Long> mList : groups.values()) {
            if (mList.size() < 2) continue;
            Set<Long> mSet = new HashSet<>(mList);
            for (long m : mList) {
                // Here b = k * m^2. We look for s = r^2.
                // b * s = k * (m*r)^2. So we look for m, m*r, m*r^2... in the mSet.
                for (long r = 2; ; r++) {
                    if (m > LIMIT / r) break;
                    long nextM = m * r;
                    if (!mSet.contains(nextM)) {
                        if (r * r > 1_000_000_000_000_000_000L / (m*m)) break; 
                        continue; 
                    }
                    
                    // Valid r found, check progression length
                    long tempM = m;
                    for (int p = 1; p <= K; p++) {
                        if (tempM > LIMIT / r) break;
                        tempM *= r;
                        if (mSet.contains(tempM)) {
                            // Reconstruct original values to get range count
                            long startVal = getValFromParts(m, groups); // Logic placeholder
                            // Using a more direct approach for the k groups:
                        } else break;
                    }
                }
            }
        }
        
        // Simplified Perfect Square Logic for clarity
        for (long k : groups.keySet()) {
            List<Long> mList = groups.get(k);
            Set<Long> mSet = new HashSet<>(mList);
            for (long m : mList) {
                for (long r = 2; ; r++) {
                    if (m > LIMIT / r) break;
                    long currM = m;
                    for (int p = 1; p <= K; p++) {
                        if (currM > LIMIT / r) break;
                        currM *= r;
                        if (mSet.contains(currM)) {
                            maxScore = Math.max(maxScore, getRangeCount(k*m*m, k*currM*currM, unique, prefixFreq));
                        } else break;
                    }
                }
            }
        }

        System.out.println(maxScore);
    }

    static long getRangeCount(long start, long end, long[] unique, long[] prefix) {
        int left = Arrays.binarySearch(unique, start);
        int right = Arrays.binarySearch(unique, end);
        return prefix[right] - (left > 0 ? prefix[left - 1] : 0);
    }

    static long[] getSquareFreeParts(long n) {
        long m = 1;
        long temp = n;
        for (long i = 2; i * i <= temp; i++) {
            while (temp % (i * i) == 0) {
                m *= i;
                temp /= (i * i);
            }
            if (temp % i == 0) { /* leave as square-free */ }
        }
        return new long[]{temp, m}; // [k, m] where n = k * m^2
    }
    
    static long getValFromParts(long m, Map<Long, List<Long>> groups) {
        return 0; // Helper not needed with the flattened loop above
    }
}