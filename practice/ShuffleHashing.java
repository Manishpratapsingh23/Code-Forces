import java.util.Scanner;
public class ShuffleHashing {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) solve(sc);
    }

    private static void solve(Scanner sc){
        String pass = sc.next();
        String hash = sc.next();
        if(pass.length()>hash.length()) {
            System.out.println("No");
            return;
        }

        int freq[] = new int[26];
        for(char ch : pass.toCharArray()) freq[ch-'a']++;

        for(int i=0;i<hash.length()-pass.length();i++){
            int count[] = freq.clone();
            boolean check = true;
            for(int j=i;j<i+pass.length();j++){
                int idx = hash.charAt(j)-'a';
                 count[idx]--;
                if (count[idx] < 0) { 
                    check = false;
                    break;
                }
            }
            if(check){
                    System.out.println("Yes");
                    return;
                }
        }
        System.out.println("No");
    }
}
