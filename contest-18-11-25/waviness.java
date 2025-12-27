import java.util.Scanner;
class waviness {
    public static int totalWaviness(int num1, int num2) {
        int i = Math.max(100,num1);
        int ans = 0;
        for(;i<=num2;i++){
            String s = String.valueOf(i);
            for(int j=1;j<s.length()-1;j++){
                char ch1 = s.charAt(j-1);
                char ch2 = s.charAt(j);
                char ch3 = s.charAt(j+1);
                if(ch2>ch1 && ch2>ch3) ans++;
                if(ch2<ch1 && ch2<ch3) ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(totalWaviness(198,202));
    }
}