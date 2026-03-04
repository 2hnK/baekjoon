import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[][] dist;
    static ArrayList<ArrayList<Edge>> adjList;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점
        M = Integer.parseInt(st.nextToken()); // 간선
        K = Integer.parseInt(st.nextToken()); // 층수

        dist = new long[2][N + 1];
        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            adjList.get(u).add(new Edge(v, c, 0));
            adjList.get(v).add(new Edge(u, c, 0));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            long c = Integer.parseInt(st.nextToken());
            if (c != -1) {
                adjList.get(i).add(new Edge(i, c * (K - 1), 0));
            }
        }

        long INF = Long.MAX_VALUE / 2;
        for (long[] row : dist) {
            Arrays.fill(row, INF);
        }
        solve();

        if (dist[1][N] == INF)
            System.out.println(-1);
        else
            System.out.println(dist[1][N]);
    }

    private static void solve() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0, 0));
        dist[0][1] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (dist[cur.flag][cur.vertex] < cur.value)
                continue;

            for (Edge next : adjList.get(cur.vertex)) {
                // 같은 층 이동
                if (next.vertex != cur.vertex) {
                    long nextDist = cur.value + next.value;

                    if (dist[cur.flag][next.vertex] > nextDist) {
                        dist[cur.flag][next.vertex] = nextDist;
                        pq.add(new Edge(next.vertex, nextDist, cur.flag));
                    }
                }
                // 엘리베이터 탑승
                else if (cur.flag == 0) {
                    long nextDist = cur.value + next.value;

                    if (dist[1][next.vertex] > nextDist) {
                        dist[1][next.vertex] = nextDist;
                        pq.add(new Edge(next.vertex, nextDist, 1));
                    }
                }
            }
        }
    }

}

class Edge implements Comparable<Edge> {
    int vertex, flag;
    long value;

    public Edge(int vertex, long value, int flag) {
        this.vertex = vertex;
        this.value = value;
        this.flag = flag;
    }

    @Override
    public int compareTo(Edge e) {
        return Long.compare(this.value, e.value);
    }
}