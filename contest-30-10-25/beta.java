import java.util.Scanner;

public class beta {


    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();
        char grid[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j=0;j<n;j++) grid[i][j] = s.charAt(j);
        }

        if(!isValid(n, grid)){
            System.out.println("No");
            return;
        }
        // if (helper(n, grid)) System.out.println("Yes");
        // else System.out.println("No");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '#') {
                    if (i+1 < n && j+1 < n) {
                        if (grid[i+1][j] != '#' && grid[i][j+1] != '#') {
                            System.out.println("No");
                            return;
                        }
                    }
                    // Edge cases: bottom row and rightmost column are fine
                }
            }
        }
        System.out.println("Yes");
        
    }

    private static boolean helper(int n, char grid[][]){
        for (int i = 0; i < n; i++) {
            for(int j=0;j<n;j++){
                if(grid[i][j]=='.'){
                    grid[i][j]='#';
                    if(isValid(n,grid)){
                        if(helper(n,grid)) return true;
                        else grid[i][j]='.';
                    }
               }
            }
        }
        return false;
    }

    private static boolean isValid(int n, char[][] grid){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - 3; j++) {
                if (grid[i][j] == '#' && grid[i][j+1] == '#' && grid[i][j+2] == '#')
                    return false;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= n - 3; i++) {
                if (grid[i][j] == '#' && grid[i+1][j] == '#' && grid[i+2][j] == '#')
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            solve_kro(sc);
        }
    }
}