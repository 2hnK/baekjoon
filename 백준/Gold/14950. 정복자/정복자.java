import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 줄 세우기 */
public class Main {

    static int N, M, T;
    static ArrayList<ArrayList<Edge>> adjList;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.get(a).add(new Edge(b, c));
            adjList.get(b).add(new Edge(a, c));
        }

        int res = prim();

        System.out.println(res);
    }

    public static int prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(1, 0));
        int totalWeight = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();

            if (visited[curEdge.to])
                continue;

            visited[curEdge.to] = true;
            totalWeight += curEdge.weight;
            count++;

            if (count == N)
                break;

            for (Edge e : adjList.get(curEdge.to)) {
                if (!visited[e.to]) {
                    pq.offer(e);
                }
            }
        }

        return totalWeight + (N - 1) * (N - 2) * T / 2;
    }

    static class Edge implements Comparable<Edge> {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

}