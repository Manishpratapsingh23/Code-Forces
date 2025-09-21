import java.util.Scanner;
public class beta {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            int arr[][] = new int[n][4];
            boolean check = true;
            for(int i=0;i<n;i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                arr[i][2] = sc.nextInt();
                arr[i][3] = sc.nextInt();
                if(arr[i][0]!=arr[i][2] || arr[i][1]!=arr[i][3]){
                    check = false;
                }
            }
                if(check){
                    System.out.println(0);
                    continue;
                }
                long result = 0;
                for(int nums[] : arr){
                    long x = nums[0]-nums[2];
                    long y = nums[1]-nums[3];
                   result += Math.max(0L,x) + Math.max(0L,y);
                    if(nums[1]>nums[3]) result+=Math.min(nums[0],nums[2]);
                }
                System.out.println(result);
            }
    }
}
