import java.util.TreeSet;
import java.util.Set;
import java.util.Scanner;

public class alpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            solve_kro(sc);
        }
       
    }

    private static void solve_kro(Scanner sc){
        //Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        Set<Long> set = new TreeSet<>();
        for(int i=1;i<=18;i++){
            long div = 1+(long)(Math.pow(10,i));
            if(div>num) break;
            if(num%div==0) set.add(num/div);

        }

        if(set.isEmpty()) System.out.println(0);
        else{
            System.out.println(set.size());
            for (long x : set) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
