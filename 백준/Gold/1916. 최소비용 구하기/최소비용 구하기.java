import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, S, E;
    static int[] dist;
    static ArrayList<ArrayList<Node>> adjList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 도시의 개수
        M = Integer.parseInt(br.readLine()); // 버스의 개수

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList.get(u).add(new Node(v, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); // 출발 도시
        E = Integer.parseInt(st.nextToken()); // 도착 도시

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(S);
        System.out.println(dist[E]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int idx = cur.idx;
            int weight = cur.weight;

            if (dist[idx] < weight)
                continue;

            for (Node next : adjList.get(idx)) {
                int nextIdx = next.idx;
                int nextWeight = next.weight + weight;
                if (nextWeight < dist[nextIdx]) {
                    dist[nextIdx] = nextWeight;
                    pq.offer(new Node(nextIdx, nextWeight));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int idx, weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

}
