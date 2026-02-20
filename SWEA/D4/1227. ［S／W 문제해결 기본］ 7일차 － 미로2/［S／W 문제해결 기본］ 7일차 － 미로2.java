import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* 미로2 */
public class Solution {

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int res;
    static int[][] map;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static final int ROAD = 0, WALL = 1, START = 2, END = 3;
    static Node start, end;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {

            int T = Integer.parseInt(br.readLine());
            map = new int[100][100];

            // 맵 입력
            for (int i = 0; i < 100; i++) {
                String s = br.readLine();

                for (int j = 0; j < 100; j++) {
                    map[i][j] = s.charAt(j) - '0';

                    if (map[i][j] == 2) {
                        start = new Node(i, j);
                    }
                }
            }

            res = 0;
            bfs();

            sb.append("#").append(T).append(" ").append(res).append("\n");
        } // End Of TestCase

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Node> q = new ArrayDeque<>();

        q.offer(start);
        map[start.r][start.c] = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int r = cur.r;
            int c = cur.c;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (map[nr][nc] == 3) {
                    res = 1;
                    return;
                }

                if (nr < 0 || nr >= 100 || nc < 0 || nr >= 100 || map[nr][nc] == 1) {
                    continue;
                }

                if (map[nr][nc] == 0) {
                    q.offer(new Node(nr, nc));
                    map[nr][nc] = 1;
                }
            }
        }
    }
}