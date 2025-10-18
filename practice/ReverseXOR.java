import java.util.Scanner;

public class ReverseXOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0)  solve(sc);
    }

    private static void solve(Scanner sc){
        int n = sc.nextInt();
        
        int count = 0;
        for(int i=0;i<32;i++){
            if(((n>>i)&1)%2==1) count++;
        }
        if(count%2==1){
            System.out.println("No");
        } else {
             System.out.println("Yes");
        }

    }
}
