import java.util.Scanner;

public class eagle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int ans=Integer.MAX_VALUE;
            String s1 = Integer.toString(l);
            String s2 = Integer.toString(r);
            int count  = 0;
            int  x = 0;
            for(int i = 0; i<s1.length(); i++){
                char ch1=s1.charAt(i);
                char ch2=s2.charAt(i);
                int diff = Math.abs((ch1-'0')-(ch2-'0'));
                if(ch1==ch2) count++;
                else if(diff>2) break;
                else x++;
            }
            System.out.println(2*count+x);
        }

    }

    public static int find(int x, int y){
        int count=0;
        while(x!=0 && y!=0){
            if(x%10==y%10)  count++;
            x/=10;
            y/=10;
        }
        return count;
    }
}