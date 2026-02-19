import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K, X, res;
    static ArrayList<Integer>[] adjList;
    static int[] dist;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); // 도시의 수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수
        K = Integer.parseInt(st.nextToken()); // 목표 거리
        X = Integer.parseInt(st.nextToken()); // 출발 도시 번호
        res = 0;

        // 거리 배열 초기화
        dist = new int[N + 1];
        Arrays.fill(dist, -1);

        // 인접리스트 초기화
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 인접리스트 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
        }

        bfs();

        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append("\n");
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }

    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(X); // 시작 위치
        dist[X] = 0; // 시작 거리 0

        while (!q.isEmpty()) {
            int curNode = q.poll();

            for (int nextNode : adjList[curNode]) {
                if (dist[nextNode] == -1) {
                    dist[nextNode] = dist[curNode] + 1;
                    q.offer(nextNode);
                }
            }

        }

    }

}