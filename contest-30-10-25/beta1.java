import java.util.*;

public class beta1 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            char[][] grid = new char[n][n];
            
            for (int i = 0; i < n; i++) {
                grid[i] = sc.next().toCharArray();
            }
            
            System.out.println(solve(n, grid) ? "YES" : "NO");
        }
        sc.close();
    }
    
    static boolean solve(int n, char[][] grid) {
        // Check if there are already 3 consecutive black cells
        if (hasThreeConsecutive(n, grid)) {
            return false;
        }
        
        // Count black cells and find them
        List<int[]> blackCells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '#') {
                    blackCells.add(new int[]{i, j});
                }
            }
        }
        
        // If no black cells, we can paint one
        if (blackCells.isEmpty()) {
            return true;
        }
        
        // If only one black cell, it's already connected
        if (blackCells.size() == 1) {
            return true;
        }
        
        // Check if we can connect all black cells
        return canConnect(n, grid, blackCells);
    }
    
    static boolean hasThreeConsecutive(int n, char[][] grid) {
        // Check rows
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - 3; j++) {
                if (grid[i][j] == '#' && grid[i][j+1] == '#' && grid[i][j+2] == '#') {
                    return true;
                }
            }
        }
        
        // Check columns
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= n - 3; i++) {
                if (grid[i][j] == '#' && grid[i+1][j] == '#' && grid[i+2][j] == '#') {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    static boolean canConnect(int n, char[][] grid, List<int[]> blackCells) {
        // Try to connect all black cells using BFS
        // Start from first black cell and see if we can reach all others
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        
        int[] start = blackCells.get(0);
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int reachable = 1;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            
            // Try all 4 directions
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    // Check if we can paint this cell or it's already black
                    if (grid[nx][ny] == '#' || canPaint(n, grid, nx, ny)) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        if (grid[nx][ny] == '#') {
                            reachable++;
                        }
                    }
                }
            }
        }
        
        return reachable == blackCells.size();
    }
    
    static boolean canPaint(int n, char[][] grid, int x, int y) {
        // Check if painting (x, y) would create 3 consecutive black cells
        
        // Check horizontal
        int leftCount = 0, rightCount = 0;
        if (y > 0 && grid[x][y-1] == '#') leftCount++;
        if (y > 1 && grid[x][y-2] == '#') leftCount++;
        if (y < n-1 && grid[x][y+1] == '#') rightCount++;
        if (y < n-2 && grid[x][y+2] == '#') rightCount++;
        
        if (leftCount == 2 || rightCount == 2) return false;
        if (y > 0 && y < n-1 && grid[x][y-1] == '#' && grid[x][y+1] == '#') return false;
        
        // Check vertical
        int topCount = 0, bottomCount = 0;
        if (x > 0 && grid[x-1][y] == '#') topCount++;
        if (x > 1 && grid[x-2][y] == '#') topCount++;
        if (x < n-1 && grid[x+1][y] == '#') bottomCount++;
        if (x < n-2 && grid[x+2][y] == '#') bottomCount++;
        
        if (topCount == 2 || bottomCount == 2) return false;
        if (x > 0 && x < n-1 && grid[x-1][y] == '#' && grid[x+1][y] == '#') return false;
        
        return true;
    }
}