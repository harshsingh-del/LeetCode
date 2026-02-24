import java.util.*;

class Solution {

    static class State {
        int node, cost, stops;
        State(int n, int c, int s) {
            node = n;
            cost = c;
            stops = s;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] f : flights) {
            graph[f[0]].add(new int[]{f[1], f[2]});
        }
        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> a.cost - b.cost
        );

        pq.offer(new State(src, 0, 0));
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.node == dst) return cur.cost;
            if (cur.stops > k) continue;

            for (int[] next : graph[cur.node]) {
                int nextNode = next[0];
                int price = next[1];
                int newCost = cur.cost + price;

                if (newCost < dist[nextNode][cur.stops + 1]) {
                    dist[nextNode][cur.stops + 1] = newCost;
                    pq.offer(new State(nextNode, newCost, cur.stops + 1));
                }
            }
        }

        return -1;
    }
}
