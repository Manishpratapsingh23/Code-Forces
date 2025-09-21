import java.util.*;

public class charlie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
             int n = sc.nextInt();
            int k = sc.nextInt();
            int heights_tower[] = new int[n];
            int max = -1;
            for(int i=0;i<n;i++){
                heights_tower[i] = sc.nextInt();
                max = Math.max(max,heights_tower[i]);
            }
            if(max==heights_tower[k-1]){
                System.out.println("Yes");
                continue;
            }
            int initial_h=heights_tower[k-1];
            Arrays.sort(heights_tower);
            int pos = binarySearch(heights_tower,initial_h);
            boolean check = true;
            for(int i=pos;i+1<n;i++){
                if(heights_tower[i+1]-heights_tower[i]>initial_h){
                    check=false;
                    break;
                }
            }
            if(check) System.out.println("Yes");
            else System.out.println("No");
        }
       
    }
    private static int binarySearch(int heights_tower[] ,int initial_h){
        int s = 0;
        int l = heights_tower.length-1;
        int ans = 0;
        while(s<=l){
            int m = (s+l)/2;
            if(heights_tower[m]>initial_h) l = m-1;
            else if(heights_tower[m]<initial_h) s = m+1;
            else {
                ans = m;
                break;
            }
        }
        return ans;
    }
}