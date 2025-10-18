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
        int n = sc.nextInt();
        String s = sc.next();
        int count = 0;
        for( char ch : s.toCharArray()){
            if(ch=='0') count++;
        }
        if(count == 0){
            System.out.println(0);
            
        } else {
            System.out.println(count);
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='0'){
                    System.out.print(i+1+" ");
                }
            }
            
        }
        System.out.println();
    }
}
