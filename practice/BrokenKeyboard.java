import java.util.Scanner;
public class BrokenKeyboard {
    private static StringBuilder append;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) solve(sc);
    }

    private static void solve(Scanner sc){
        String s = sc.next();
        int l = s.length();
        boolean ans[] = new boolean[26];
        for(int i=0;i<l;i++){
            int j=i;
            while(j+1<l && s.charAt(j+1)==s.charAt(i)) j++;
            if((j-i)%2==0) ans[s.charAt(i)-'a'] = true;
            i=j;
        }

        for(int i=0;i<26;i++){
            if(ans[i]){
                System.out.print((char)('a'+i));
            }
        }
        System.out.println();

    }
}
