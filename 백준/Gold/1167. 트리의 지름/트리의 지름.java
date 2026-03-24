import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<ArrayList<Edge>> adjList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1)
                    break;
                int weight = Integer.parseInt(st.nextToken());
                adjList.get(from).add(new Edge(from, to, weight));
            }
        }

        int idx = bfs(new Edge(0, 1, 0))[0];
        int res = bfs(new Edge(0, idx, 0))[1];
        System.out.println(res);
    }

    private static int[] bfs(Edge s) {
        ArrayDeque<Edge> dq = new ArrayDeque<>();
        visited = new boolean[N + 1];
        dist = new int[N + 1];

        dq.offer(s);
        visited[s.to] = true;

        int max_dist = 0;
        int max_idx = 0;
        while (!dq.isEmpty()) {
            Edge cur = dq.poll();

            for (Edge e : adjList.get(cur.to)) {
                if (!visited[e.to]) {
                    visited[e.to] = true;
                    dist[e.to] = dist[e.from] + e.weight;
                    dq.offer(e);

                    if (max_dist < dist[e.to]) {
                        max_dist = dist[e.to];
                        max_idx = e.to;
                        // System.out.println(e);
                        // System.out.println("max_dist: " + max_dist + ", max_idx: " + max_idx);
                    }
                }
            }
        }
        int[] res = { max_idx, max_dist };
        return res;
    }

    static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
        }
    }
}
