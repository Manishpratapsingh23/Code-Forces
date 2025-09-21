
import java.util.Arrays;
import java.util.Scanner;

public class charlie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];
            int firstMaximum = 0;
        int secondMaximum = 0;

        int[] row_newCount = new int[n];
        int[] col_newCount = new int[m];

        int totalMaximumCount = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                arr[i][j] = sc.nextInt();

                if (arr[i][j] > firstMaximum) {
                    secondMaximum = firstMaximum;
                    firstMaximum = arr[i][j];

                    totalMaximumCount = 1;

                    Arrays.fill(row_newCount, 0);
                    Arrays.fill(col_newCount, 0);

                    row_newCount[i]++;
                    col_newCount[j]++;

                } else if (arr[i][j] == firstMaximum) {
                    totalMaximumCount++;
                    row_newCount[i]++;
                    col_newCount[j]++;
                } else {
                    secondMaximum = Math.max(secondMaximum, arr[i][j]);
                }
            }
        }

        boolean canBeReduced = false;

        for (int i = 0; i < n && !canBeReduced; ++i) {
            for (int j = 0; j < m; ++j) {

                int newCount = row_newCount[i] + col_newCount[j];

                if (arr[i][j] == firstMaximum) newCount--;  

                if (newCount >= totalMaximumCount) {
                    canBeReduced = true;
                    break;
                }
            }
        }

        if (canBeReduced) {
            System.out.println(Math.max(firstMaximum - 1, secondMaximum));
        } else {
            System.out.println(firstMaximum);
        }
        }
    }
}
