import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int V, E, START;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<ArrayList<Edge>> adjList;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 입력 값
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(br.readLine());

        // 배열 초기화
        adjList = new ArrayList<>();
        pq = new PriorityQueue<>();
        distance = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList.get(u).add(new Edge(v, w));
        }

        // 다익스트라
        pq.add(new Edge(START, 0));
        distance[START] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int c_v = cur.vertex;

            if (visited[c_v])
                continue;
            visited[c_v] = true;

            for (int i = 0; i < adjList.get(c_v).size(); i++) {
                Edge temp = adjList.get(c_v).get(i);
                int next = temp.vertex;
                int value = temp.value;
                if (distance[next] > distance[c_v] + value) {
                    distance[next] = distance[c_v] + value;
                    pq.add(new Edge(next, distance[next]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (visited[i])
                sb.append(distance[i]).append("\n");
            else
                sb.append("INF\n");
        }
        System.out.println(sb);
    }

    static class Edge implements Comparable<Edge> {
        int vertex, value;

        Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge e) {
            if (this.value > e.value)
                return 1;
            else
                return -1;
        }
    }

}