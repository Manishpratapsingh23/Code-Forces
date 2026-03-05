import java.util.*;

class hack1 {

    /*
     * Complete the 'countReverseEdges' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER gNodes
     * 2. INTEGER_ARRAY gFrom
     * 3. INTEGER_ARRAY gTo
     */
    public static List<Integer> countReverseEdges(int gNodes, List<Integer> gFrom, List<Integer> gTo) {
        // Build an adjacency list where each edge stores {neighbor, weight}
        // Weight is 0 if it's an original directed edge (u -> v)
        // Weight is 1 if it's a reversed edge (v -> u)
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= gNodes; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < gFrom.size(); i++) {
            int u = gFrom.get(i);
            int v = gTo.get(i);
            adj.get(u).add(new int[]{v, 0}); // Cost to travel u -> v is 0
            adj.get(v).add(new int[]{u, 1}); // Cost to travel v -> u is 1 (needs reverse)
        }
        
        int[] ans = new int[gNodes + 1];
        
        // Step 1: Calculate total reversals needed if we start at node 1
        ans[1] = dfs1(1, 0, adj);
        
        // Step 2: Propagate the result to all other nodes dynamically
        dfs2(1, 0, adj, ans);
        
        // Collect results for nodes 1 to gNodes
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= gNodes; i++) {
            result.add(ans[i]);
        }
        
        return result;
    }
    
    // DFS to find the total cost of reaching all nodes starting from 'u'
    private static int dfs1(int u, int parent, List<List<int[]>> adj) {
        int cost = 0;
        for (int[] edge : adj.get(u)) {
            int v = edge[0];
            int weight = edge[1];
            if (v != parent) {
                cost += weight + dfs1(v, u, adj);
            }
        }
        return cost;
    }
    
    // DFS to re-root the tree and calculate costs for all other nodes based on their parent's cost
    private static void dfs2(int u, int parent, List<List<int[]>> adj, int[] ans) {
        for (int[] edge : adj.get(u)) {
            int v = edge[0];
            int weight = edge[1]; 
            
            if (v != parent) {
                // If weight == 0 (original edge u -> v), moving root to v adds 1 to cost
                // If weight == 1 (reversed edge v -> u), moving root to v subtracts 1 from cost
                ans[v] = ans[u] + (weight == 0 ? 1 : -1);
                dfs2(v, u, adj, ans);
            }
        }
    }

    public static int getSwapTime(String color) {
        int zeros = 0;
        int seconds = 0;
        
        // Iterate through the string from left to right
        for (int i = 0; i < color.length(); i++) {
            if (color.charAt(i) == '0') {
                // Count the number of zeros encountered so far
                zeros++;
            } else if (zeros > 0) {
                // If we see a '1' and there are zeros to its left, it needs to move.
                // It will either take 'zeros' steps, or 1 step more than the preceding '1'.
                seconds = Math.max(seconds + 1, zeros);
            }
        }
        
        return seconds;
    }


    public static void main(String[] args) {
        List<Integer> arr= new ArrayList<>();
        List<Integer> arr1= new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr1.add(4);
        arr1.add(4);
        arr1.add(4);

        //System.out.println(countReverseEdges(4,arr,arr1));

        System.out.println(getSwapTime("001011"));
        System.out.println(getSwapTime("0101"));
    }
}


// -- Create the companies table
// CREATE TABLE companies (
//     id SMALLINT PRIMARY KEY,
//     name VARCHAR(255),
//     phone VARCHAR(255),
//     is_promoted SMALLINT
// );

// -- Create the categories table
// CREATE TABLE categories (
//     id SMALLINT PRIMARY KEY,
//     name VARCHAR(255)
// );

// -- Create the reviews table
// CREATE TABLE reviews (
//     company_id SMALLINT,
//     category_id SMALLINT,
//     rating SMALLINT,
//     FOREIGN KEY (company_id) REFERENCES companies(id),
//     FOREIGN KEY (category_id) REFERENCES categories(id)
// );


// -- Insert data into companies
// INSERT INTO companies (id, name, phone, is_promoted) VALUES
// (1, 'Schmeler-Romaguera', '+62 (439) 600-9960', 0),
// (2, 'Leuschke, Fisher and Towne', '+509 (105) 921-8036', 0),
// (3, 'Predovic LLC', '+33 (311) 928-8329', 1);

// -- Insert data into categories
// INSERT INTO categories (id, name) VALUES
// (1, 'Sitework & Site Utilities'),
// (2, 'Roofing (Metal)'),
// (3, 'Electrical'),
// (4, 'Elevator'),
// (5, 'Marlite Panels (FED)');

// -- Insert data into reviews
// INSERT INTO reviews (company_id, category_id, rating) VALUES
// (1, 1, 4),
// (1, 3, 5),
// (1, 4, 2),
// (2, 1, 5),
// (2, 1, 3),
// (2, 2, 1);