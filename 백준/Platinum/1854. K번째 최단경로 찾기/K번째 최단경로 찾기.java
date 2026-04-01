import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static ArrayList<ArrayList<Node>> adjList;
    static PriorityQueue<Integer>[] distPQ;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 수
        K = Integer.parseInt(st.nextToken()); // K번째 최단경로

        adjList = new ArrayList<>();
        distPQ = new PriorityQueue[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
            distPQ[i] = new PriorityQueue<>(K, Collections.reverseOrder()); // 최대 힙
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList.get(u).add(new Node(v, w));
        }

        dijkstra(1);

        for (int i = 1; i <= N; i++) {
            if (distPQ[i].size() < K)
                sb.append("-1\n");
            else
                sb.append(distPQ[i].peek()).append("\n");
        }

        System.out.println(sb);
    }

    public static void dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        distPQ[s].add(0);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curIdx = cur.index;
            int curDist = cur.distance;

            for (Node n : adjList.get(curIdx)) {
                int cost = curDist + n.distance;

                if (distPQ[n.index].size() < K) {
                    distPQ[n.index].add(cost);
                    pq.add(new Node(n.index, cost));
                } else if (distPQ[n.index].peek() > cost) {
                    distPQ[n.index].poll();
                    distPQ[n.index].add(cost);
                    pq.add(new Node(n.index, cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int index, distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
}

/*
 * K번째 최단경로를 찾기 위해서는 기존의 distance[] 배열만으로는 구할 수 없기 때문에 상위 K개의 최단거리를 저장할 자료구조가
 * 필요하다. 따라서 문제를 해결하기 위해 최대힙 자료구조를 사용해서 문제에 접근할 수 있다. 각각의 노드의 PriorityQueue를
 * 관리하여 해당 노드까지 방문하는데 소요되는 시간을 정렬된 상태로 관리하여 K개의 최단거리를 관리할 수 있다.
 */