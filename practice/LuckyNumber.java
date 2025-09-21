
import java.util.Scanner;

public class LuckyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int test = sc.nextInt();

        // while (test-- > 0) {
        //     solve_kro(sc);
        // }
        solve_kro(sc);
       
    }

    private static void solve_kro(Scanner sc){
        long n = sc.nextInt();
        // int four = 0, seven = 0, length = 0;
        // String s = String.valueOf(n);
        // length = s.length();
        // if(length%2==0) s+='0';
        // for(char ch : s.toCharArray()){
        //     if(ch=='4') four++;
        //     else if(ch=='7') seven++;
        // }
        // int left = length-seven-four;
        // int req_four = length/2-four;
        // int req_seven = length/2-seven;
        // StringBuilder sb = new StringBuilder();
        // for(char ch : s.toCharArray()){
        //     if(ch!='4' && ch!='7'){
        //         if(ch>'4')
        //     }
        // }
        long temp = n;
        long ans = 0;
        int carry = 0;
        while(temp>0){
            temp += carry;
            long r = temp%10;
            if(r>7){
                r = 4;
                carry = 1;
            }
            else if(r<4){
                r=4;
                carry = 0;
            } else if(r==4 || r==7) carry = 0;
            else {
                r = 7;
                carry = 0;
            }
            ans = ans*10+r;
            temp = temp/10;

        }
        temp = 0;
        while(ans>0){
            long r = ans%10;
            temp = temp*10+r;
            ans = ans/10;
        }
        System.out.println(temp);
    }
}
