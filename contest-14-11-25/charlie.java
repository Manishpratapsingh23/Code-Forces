import java.util.Scanner;

public class charlie {
    private static void solve_kro(Scanner sc){
        long size = sc.nextLong();
            long[] arr = new long[(int) size];

            for (int i = 0; i < size; i++)
                arr[i] = sc.nextLong();

            long baseSum = 0;
            for (long x : arr) baseSum += x;

            long[] prefix = new long[(int) size + 1];
            for (int i = 0; i < size; i++)
                prefix[i + 1] = prefix[i] + arr[i];

            long bestGain = 0;
            long bestLeftVal = Long.MIN_VALUE;

            for (int right = 1; right <= size; right++) {

                long leftVal = right - 1L * right * right + prefix[right - 1];
                bestLeftVal = Math.max(bestLeftVal, leftVal);

                long rightVal = 1L * right * right + right - prefix[right];

                long totalGain = rightVal + bestLeftVal;

                if (totalGain > bestGain)
                    bestGain = totalGain;
            }

            System.out.println(baseSum + bestGain);

    }

    private static int binarySearch(int arr[], int a){
        int l = 0, r = arr.length - 1, ans = arr.length;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] >= a){
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve_kro(sc);
        }
    }
}