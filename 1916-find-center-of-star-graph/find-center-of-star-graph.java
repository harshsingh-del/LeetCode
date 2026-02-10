import java.util.*;

class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(edges[0][0]);
        visited[edges[0][0]] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (adj.get(curr).size() == n - 1) {
                return curr;
            }
            for (int neigh : adj.get(curr)) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.add(neigh);
                }
            }
        }

        return -1; 
    }
}
