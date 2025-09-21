import java.util.Scanner;

public class delta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String st = sc.next();
            int count_one = 0;
            for(char ch : st.toCharArray()){
                if(ch=='1') count_one++;
            }
            if(count_one<=k) System.out.println("Alice");
            else{
                int count_zero = 0;
                boolean has_k_zero = false;
                for(char ch : st.toCharArray()){
                    if(ch==0) count_zero++;
                    else count_zero=0;
                    if(count_zero>=k){
                        has_k_zero=true;
                        break;
                    }
                }
                if(has_k_zero || 2*k<=n){
                    System.out.println("Bob");
                }
                else{
                    System.out.println("Alice");
                }
            }
        }
    }
}