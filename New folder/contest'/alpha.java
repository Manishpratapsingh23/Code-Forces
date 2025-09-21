import java.util.Scanner;

public class alpha {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int a = sc.nextInt();
            if(a%4==0) System.out.println("Bob");
            else System.out.println("Alice");
        }
    }
}