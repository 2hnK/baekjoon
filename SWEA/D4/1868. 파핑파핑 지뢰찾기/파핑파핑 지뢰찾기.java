import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, res;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            // 공갈빵 찾기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == '*')
                        continue;

                    boolean flag = true;
                    for (int d = 0; d < 8; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                            continue;
                        }
                        if (map[nr][nc] == '*') {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        map[r][c] = '#';
                    }
                }
            }

            // 공갈빵 누르기
            res = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == '#' && !visited[r][c]) {
                        bfs(new Node(r, c));
                        res++;
                    }
                }
            }

            // 나머지 . 누르기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == '.' && !visited[r][c]) {
                        res++;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        } // End Of TestCase
        System.out.println(sb);
    }

    static void bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(start);
        visited[start.r][start.c] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 주변 지뢰 0개인 경우
            if (map[cur.r][cur.c] == '#') {
                for (int d = 0; d < 8; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    // 맵 확인
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        continue;
                    }

                    // 지뢰 확인
                    if (map[nr][nc] != '*' && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new Node(nr, nc));
                    }
                }
            }
        }
    }
}