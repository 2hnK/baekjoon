import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    static int V, E;
    static boolean[] visited;
    static ArrayList<ArrayList<Edge>> adjList;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            visited = new boolean[V + 1];

            adjList = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adjList.get(a).add(new Edge(b, c));
                adjList.get(b).add(new Edge(a, c));
            }

            long res = prim(1);
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }

    private static long prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(start, 0));

        long totalWeight = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.to])
                continue;

            visited[cur.to] = true;
            totalWeight += cur.v;
            count++;

            if (count == V)
                break;

            for (Edge edge : adjList.get(cur.to)) {
                if (!visited[edge.to]) {
                    pq.offer(edge);
                }
            }
        }
        return totalWeight;
    }

    static class Edge implements Comparable<Edge> {
        int to, v;

        public Edge(int to, int v) {
            this.to = to;
            this.v = v;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.v, o.v);
        }
    }
}