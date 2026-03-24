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
                adjList.get(from).add(new Edge(to, weight));
            }
        }

        int[] res1 = bfs(1);
        int[] res2 = bfs(res1[0]);
        System.out.println(res2[1]);
    }

    private static int[] bfs(int s) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        visited = new boolean[N + 1];
        dist = new int[N + 1];

        dq.offer(s);
        visited[s] = true;

        int max_dist = 0;
        int max_idx = s;
        while (!dq.isEmpty()) {
            int cur = dq.poll();

            for (Edge e : adjList.get(cur)) {
                if (!visited[e.to]) {
                    visited[e.to] = true;
                    dist[e.to] = dist[cur] + e.weight;
                    dq.offer(e.to);

                    if (max_dist < dist[e.to]) {
                        max_dist = dist[e.to];
                        max_idx = e.to;
                    }
                }
            }
        }
        return new int[] { max_idx, max_dist };
    }

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
