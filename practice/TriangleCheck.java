import java.util.*;

public class TriangleCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            sc.nextLine(); 
            List<Integer> xs = new ArrayList<>();
            List<Integer> ys = new ArrayList<>();
            
            for (int j = 0; j < 3; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                //sc.nextLine();
                xs.add(x);
                ys.add(y);
            }
            Set<Integer> setX = new HashSet<>(xs);
            Set<Integer> setY = new HashSet<>(ys);
            
            if (setX.size() == 3 || setY.size() == 3) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
