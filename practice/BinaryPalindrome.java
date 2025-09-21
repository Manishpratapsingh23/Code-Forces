import java.util.Scanner;
public class BinaryPalindrome {
    static int oddStrings, evenBadStrings;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            oddStrings = 0;
            evenBadStrings = 0;
            solve(sc);
        }
    }

    private static void solve(Scanner sc){
        int n = sc.nextInt();
        //String arr[] = new String[n];
        for(int i=0;i<n;i++){
            String s = sc.next();
            compute(s);
        }
        if(evenBadStrings%2==1 && oddStrings==0){
            System.out.println(n-1);
            return;
        }
        System.out.println(n);
        
    }

    private static void compute(String s){
        int l = s.length();
        if(l%2==1){
            oddStrings++;
            return;
        }
        int oddCount = 0;
        for(char ch : s.toCharArray()){
            if(ch=='0') oddCount++;
        }
        if(oddCount%2==1) evenBadStrings++;
    }
}
