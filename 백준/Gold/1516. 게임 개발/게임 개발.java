import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] indegree, buildTime, result;
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); // 건물의 종류 수 [1, 500]

        adjList = new ArrayList[N + 1];
        indegree = new int[N + 1];
        buildTime = new int[N + 1];
        result = new int[N + 1];

        // adjList init
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // input
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken()); // 소요 시간

            while (true) {
                int cond = Integer.parseInt(st.nextToken()); // 선행 조건
                if (cond == -1)
                    break;
                adjList[cond].add(i);
                indegree[i]++;
            }
        }

        build();

        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void build() {
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                result[i] = buildTime[i];
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adjList[cur]) {
                indegree[next]--;

                result[next] = Math.max(result[next], result[cur] + buildTime[next]);

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}