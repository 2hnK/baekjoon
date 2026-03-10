import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 최적 경로 */
public class Solution {

    static int N, res;
    static boolean[] visited;
    static Node[] loc;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 0: 회사, 1: 집
            loc = new Node[N + 2];
            for (int i = 0; i <= N + 1; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                loc[i] = new Node(x, y);
            }

            visited = new boolean[N + 2];
            res = Integer.MAX_VALUE;
            dfs(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int depth, int dist, int prev) {
        if (depth == N) {
            dist += calcDist(loc[prev], loc[1]);
            res = Math.min(res, dist);
            return;
        }

        if (res < dist)
            return;

        for (int i = 2; i <= N + 1; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            if (depth == 0) { // 회사와 고객의 거리
                dfs(depth + 1, dist + calcDist(loc[0], loc[i]), i);
            } else { // 집과 고객의 거리
                dfs(depth + 1, dist + calcDist(loc[prev], loc[i]), i);
            }
            visited[i] = false;
        }
    }

    private static int calcDist(Node n1, Node n2) {
        int absX = Math.abs(n1.x - n2.x);
        int absY = Math.abs(n1.y - n2.y);

        return absX + absY;
    }

}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}