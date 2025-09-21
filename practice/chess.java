import java.util.Scanner;

public class chess {
    private static int x1,y1,x2,y2;
    private static boolean grid[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        grid = new boolean[8][8];
        solve(sc);
    }

    private static void solve(Scanner sc){
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        x1 = input1.charAt(0) - 'a';
        y1 = input1.charAt(1) - '1';
        x2 = input2.charAt(0) - 'a';
        y2 = input2.charAt(1) - '1';

        // for(boolean arr[] : grid) Arrays.fill(arr, true);
        // for(int i=0;i<8;i++){
        //     grid[x1][i] = false;
        //     grid[i][y1] = false;
        // } 

        // grid[x2][y2] = false;
        // change(x1, y1);
        // change(x2, y2);

        // count();

        int ways = 0;
        for (int i = 0; i < 8; i++) {
            for(int j=0; j<8; j++){
                if((i==x1 && j ==y1) || (i==x2 && j==y2)) continue;
                if(i==x1 || j==y1) continue;
                // check if existing knight must not kill new knight on new grid
                if(isKnightKilled(i,j,x2,y2)) continue;

                // new knight must not kill root and existing knight
                if(isKnightKilled(i,j,x1,y1)) continue;
                //if(isKnightKilled(i,j,x2,y2)) continue;

                ways++;
            }
        }
        System.out.println(ways);

    }

    private static boolean isKnightKilled(int i, int j, int x, int y){
        int xx = Math.abs(i-x);
        int yy = Math.abs(j-y);
        return (xx==1 && yy==2) || (xx==2 && yy==1);
    }

    private static void change(int x, int y){
        if(x+2 < 8){
            if(y-1>=0) grid[x+2][y-1] = false;
            if(y+1<8 ) grid[x+2][y+1] = false;
        }
        if(x-2 >= 0){
            if(y-1>=0) grid[x-2][y-1] = false;
            if(y+1<8 ) grid[x-2][y+1] = false;
        }

        if(y+2 < 8){
            if(x-1>=0) grid[x-1][y+2] = false;
            if(x+1<8 ) grid[x+1][y+2] = false;
        }
         if(y-2 >= 0){
            if(x-1>=0) grid[x-1][y-2] = false;
            if(x+1<8 ) grid[x+1][y-2] = false;
        }
    }

    private static void count(){
        int ans = 0;
        for(boolean arr[] : grid){
            for(boolean b : arr){
                if(b==true) ans++;
            }
        }
        System.out.println(ans);
    }

}
