import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class beta {

    // prime check TC: O(underroot N)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            String t = sc.next();
            solve_kro(s, t);
        }
        sc.close();
    }

    private static void solve_kro(String s, String t) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) freq[ch - 'a']++;
        for (char ch : t.toCharArray()) freq[ch - 'a']--;

        for (int val : freq) {
            if (val != 0) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}