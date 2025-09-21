import java.util.Scanner;

public class beta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc); 
        }
    }

    private static void solve_kro(Scanner sc){
        int al = sc.nextInt();
        String as = sc.next();  

        int bl = sc.nextInt();
        String bs = sc.next();

        String change = sc.next();

        for(int i = 0; i < bl; i++){
            if(change.charAt(i) == 'V') {
                as = bs.charAt(i) + as;
            } else {
                as = as + bs.charAt(i);
            }
        }
        System.out.println(as);
    }
}
