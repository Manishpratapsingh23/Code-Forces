import java.util.*;

public class delta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            int coins = sc.nextInt();
            int casino[][] = new int[n][3];
            for(int i=0;i<n;i++){
                casino[i][0]=sc.nextInt();
                casino[i][1]=sc.nextInt();
                casino[i][2]=sc.nextInt();
            }
            Arrays.sort(casino, (a,b) -> Integer.compare(a[2],b[2]));
            for(int arr[] : casino){
                if(coins>=arr[0] && coins<=arr[1]){
                    if(coins<=arr[2]) coins = arr[2];
                }
            }
            System.out.println(coins);

        }
       
    }
}