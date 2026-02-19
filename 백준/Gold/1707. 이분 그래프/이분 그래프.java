import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int K, V, E;
    static ArrayList<Integer>[] adj;
    static int[] visited; // 0, 1, 2
    static boolean result;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= K; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adj = new ArrayList[V + 1];
            visited = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adj[from].add(to);
                adj[to].add(from);
            }

            result = true;
            for (int i = 1; i <= V; i++) {
                if (visited[i] == 0) {
                    bfs(i);
                }

                if (!result)
                    break;
            }

            if (result) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);

    }

    private static void bfs(int startNode) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(startNode);
        visited[startNode] = 1;

        while (!q.isEmpty()) {
            int curNode = q.poll();

            for (int nextNode : adj[curNode]) {
                if (visited[nextNode] == 0) {
                    visited[nextNode] = 3 - visited[curNode];
                    q.offer(nextNode);
                } else if (visited[nextNode] == visited[curNode]) {
                    result = false;
                    return;
                }
            }
        }
    }
}
