import java.util.Scanner;

public class beta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            int dist[] = new int[n];
            int sum=0;
            int max_dist = 0;
            for(int i=0;i<n;i++){
                dist[i]=sc.nextInt();
                sum+=dist[i];
                max_dist = Math.max(max_dist,dist[i]);
            }
            long dx = a-p;
            long dy = b-q;
            long d = (dx*dx + dy*dy);
            int min_r = Math.max(0, 2 * max_dist - sum);
            int max_r = sum;
            if((long)min_r*min_r <= d & d<=(long)max_r*max_r) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}