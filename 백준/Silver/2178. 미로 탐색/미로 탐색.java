import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N, M, res;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }

        visited = new boolean[N + 1][M + 1];
        res = 0;
        bfs(new Node(1, 1));

        System.out.println(map[N][M]);
    }

    private static void bfs(Node s) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offer(s);
        visited[s.r][s.c] = true;

        while (!dq.isEmpty()) {
            Node cur = dq.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 1 || nr > N || nc < 1 || nc > M)
                    continue;

                if (map[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    dq.offer(new Node(nr, nc));
                    map[nr][nc] = map[cur.r][cur.c] + 1;
                }
            }
        }

    }

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
