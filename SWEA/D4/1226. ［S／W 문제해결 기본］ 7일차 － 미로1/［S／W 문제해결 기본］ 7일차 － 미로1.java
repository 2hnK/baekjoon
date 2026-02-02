import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private static final int WALL = 1;
    private static final int END = 3;

    static boolean[][] visited;
    static int[][] map;
    static int success;

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int T = Integer.parseInt(br.readLine());
            visited = new boolean[16][16];
            map = new int[16][16];
            success = 0;

            for (int i = 0; i < 16; i++) {
                String line = br.readLine();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            dfs(1, 1);

            sb.append("#").append(T).append(" ").append(success).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int r, int c) {
        if (map[r][c] == END) {
            success = 1;
            return;
        }

        visited[r][c] = true;
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        for (int dir = 0; dir < 4; dir++) {
            if (success == 1) break;
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (map[nr][nc] != WALL && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }

    }

}