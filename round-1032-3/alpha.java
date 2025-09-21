import java.util.Scanner;

public class alpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int size = sc.nextInt();
            int pos = sc.nextInt();
            int arr[] =new int[size];
            for (int i = 0; i < size; i++)       arr[i] = sc.nextInt();     
            if(size==1){
                if(pos==arr[0])
                System.out.println(0);
                else System.out.println(Math.abs(pos-arr[0]));
            }
            else if(pos<=arr[0]){
                System.out.println(arr[size-1]-pos);
            }
            else if(pos>=arr[size-1]){
                System.out.println(pos-arr[0]);
            }
            else {
                int x = Math.abs(pos-arr[0]);
                int y = Math.abs(arr[size-1]-pos);
                if(x>=y){
                System.out.println(x+2*y);
            }
            else{
                System.out.println(2*x+y);
            }
            }
        }
    }
}
