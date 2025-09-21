import java.util.Scanner;
public class beta {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
        long ax = sc.nextLong();
        long by = sc.nextLong();
        long pk = sc.nextLong();

        long step = gcd(ax,by);
        long needed_to_reach = Math.max((ax+pk-1)/pk,(by+pk-1)/pk);

        if (step >= needed_to_reach)
            System.out.println(1);
        else
            System.out.println(2);
        }
     }

     private static long gcd(long ax, long by) {
        while (by != 0) {
            long temporary = by;
            by = ax % by;
            ax = temporary;
        }
        return ax;
    }
}
