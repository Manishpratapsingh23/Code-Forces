import java.util.Scanner;

public class alpha {
    static String ISSQUAREFORMED(int[] Sides){
        if((Sides[0] == Sides[2] && Sides[2] == Sides[4]) && Sides[1]+Sides[3]+Sides[5] == Sides[0]) return "YES";
        else if(Sides[0]+Sides[2] == Sides[1] && Sides[3]+Sides[5] == Sides[1]) return "YES";
        else if((Sides[1] == Sides[3] && Sides[3] == Sides[5]) && Sides[0]+Sides[2]+Sides[4] == Sides[1]) return "YES";
        else if(Sides[1]+Sides[3] == Sides[0] && Sides[2]+Sides[4] == Sides[0]) return "YES";
        return "NO";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int[] Sides = new int[6];
            for (int j = 0; j < Sides.length; j++) {
                Sides[j] = sc.nextInt();
            }
            System.out.println(ISSQUAREFORMED(Sides));
        }
    }
}