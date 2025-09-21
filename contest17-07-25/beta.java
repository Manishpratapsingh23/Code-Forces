import java.util.Scanner;

public class beta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int weather[] = new int[n];
            for(int i=0;i<n;i++) weather[i] = sc.nextInt();
            int count = 0;
            int days = 0;
            for(int i=0;i<n;i++){
                if(days<k && weather[i]==0) days++;
                else if(days==k){
                    days = 0;
                    count++;
                } else if(weather[i]==1) days = 0;
            }
            if(days==k) count++;
            System.out.println(count);

        }
       
    }
}