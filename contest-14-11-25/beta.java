import java.util.Scanner;

public class beta {

    private static void solve_kro(Scanner sc){
        String s = sc.next();
        long a=0,b=0,c=0;
        for(char ch : s.toCharArray()){
            if(ch=='<') a++;
            else if(ch=='>') b++;
            else c++;
        }
        if(s.length()==c){
            if(c==1) System.out.println(1);
            else System.out.println(-1);
            return;
        }
        for(int i=0;i<s.length()-1;i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            if((ch1=='>' && ch2=='<') || (ch1=='>' && ch2=='*') || (ch1=='*' && ch2=='<') || (ch1=='*' && ch2=='*')){
                System.out.println(-1);
                return;
            }
        }
        long ans = Math.max(a,b)+(c>0 ? 1 : 0);
        System.out.println(ans);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve_kro(sc);
        }
    }
}