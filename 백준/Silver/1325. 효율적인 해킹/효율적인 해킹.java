import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] adjList;
    static int[] count;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); // 컴퓨터 수
        M = Integer.parseInt(st.nextToken()); // 신뢰 관계 수
        adjList = new ArrayList[N + 1];
        count = new int[N + 1];
        Arrays.fill(count, 1);

        // ArrayList 초기화
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 입력값
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
        }

        // bfs
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        int max = -1;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, count[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (count[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static void bfs(int i) {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(i);
        visited[i] = true;

        while (!q.isEmpty()) {
            int curNode = q.poll();

            for (Integer nextNode : adjList[curNode]) {
                if (visited[nextNode])
                    continue;

                visited[nextNode] = true;
                count[nextNode]++;
                q.offer(nextNode);
            }
        }
    }
}