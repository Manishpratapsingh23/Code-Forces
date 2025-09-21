import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class alpha {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
        String s = sc.next();
        int t = 0, f = 0, n = 0;
        List<Character> lst = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (ch == 'T') t++;
            else if (ch == 'F') f++;
            else if (ch == 'N') n++;
            else lst.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) sb.append('T');
        for (int i = 0; i < f; i++) sb.append('F');
        for (int i = 0; i < n; i++) sb.append('N');
        for (char ch : lst) sb.append(ch);

        System.out.println(sb);
        }
     }
}
