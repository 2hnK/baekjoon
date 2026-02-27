import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, S, D, dist;
    static ArrayList<Integer>[] adjList;
    static int[] height;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노드 개수
        S = Integer.parseInt(st.nextToken()); // 시작 위치
        D = Integer.parseInt(st.nextToken()); // 힘
        dist = 0;

        height = new int[N + 1];
        adjList = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        visited = new boolean[N + 1];
        dfs(S);

        visited = new boolean[N + 1];
        calcDist(S);

        int res = dist * 2;
        System.out.println(res);
    }

    // 각 노드의 높이 기록
    private static int dfs(int s) {
        visited[s] = true;

        int max = -1;
        for (int n : adjList[s]) {
            if (!visited[n]) {
                int h = dfs(n) + 1;
                max = Math.max(max, h);
            }
        }
        if (max == -1)
            return 0;
        else
            return height[s] = max;
    }

    // 거리 계산
    private static void calcDist(int s) {
        visited[s] = true;

        for (int n : adjList[s]) {
            if (!visited[n]) {
                visited[n] = true;

                if (height[n] >= D) {
                    dist++;
                    calcDist(n);
                }
            }
        }
    }

}
