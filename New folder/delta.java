import java.io.*;
import java.util.*;

public class delta {
    static class Edge {
        int u, v;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            List<List<Integer>> paths = new ArrayList<>();
            for (int i = 0; i <= n; i++) paths.add(new ArrayList<>());
            List<Edge> edges = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                String[] parts = br.readLine().trim().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                paths.get(u).add(v);
                paths.get(v).add(u);
                edges.add(new Edge(u, v));
            }

           
            int leaf = -1;
            for (int i = 1; i <= n; i++) {
                if (paths.get(i).size() == 1) {
                    leaf = i;
                    break;
                }
            }

            int center = -1, centerCount = 0;
            for (int i = 1; i <= n; i++) {
                if (paths.get(i).size() == n - 1) {
                    center = i;
                    centerCount++;
                }
            }

            if (n == 2) {
                System.out.println("NO");
                continue;
            }
            if (centerCount == 1) {
                System.out.println("YES");
                for (Edge e : edges) {
                    if (e.u == center) {
                        System.out.println(e.v + " " + e.u);
                    } else if (e.v == center) {
                        System.out.println(e.u + " " + e.v);
                    } else {
                        System.out.println(e.u + " " + e.v);
                    }
                }
                continue;
            }

            int cp = -1;
            for (int i = 1; i <= n; i++) {
                if (paths.get(i).size() == 2) {
                    cp = i;
                    break;
                }
            }
            if (cp == -1) {
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");
            boolean[] visited = new boolean[n + 1];
            for (int child : paths.get(cp)) {
                dfsPrint(cp, child, cp, paths, visited);
            }
        }
    }

    static void dfsPrint(int from, int curr, int block, List<List<Integer>> paths, boolean[] visited) {
        System.out.println(from + " " + curr);
        visited[curr] = true;
        for (int to : paths.get(curr)) {
            if (to != from && to != block && !visited[to]) {
                dfsPrint(curr, to, block, paths, visited);
            }
        }
    }
}
