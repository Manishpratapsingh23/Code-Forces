import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImmobileKnight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0) solve(br);
    }

    private static void solve(BufferedReader br) throws IOException{
        String num[] = br.readLine().split(" ");
        int m = Integer.parseInt(num[0]);
        int n = Integer.parseInt(num[1]);
        if(m==1 || n==1 || (m>3 && n>1) || (m>1 && n>3)){
            System.out.println(m+" "+n);
            return;
        }

        if(m==3 && n==3){
            System.out.println("2 2");
            return;
        }

        if(m==2 && n==3){
            System.out.println("1 2");
        }
        else System.out.println("2 1");



    }
}
