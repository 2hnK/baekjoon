import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] dr = { 0, 0, -1 };
    static int[] dc = { -1, 1, 0 };
    static int[][] ladder;
    static boolean find;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {

            int T = Integer.parseInt(br.readLine());
            int startCol = 0;
            int resCol = 0;

            ladder = new int[100][100];
            find = false;

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                    if (ladder[i][j] == 2)
                        startCol = j;
                }
            }

            resCol = dfs(99, startCol);
            sb.append("#").append(T).append(" ").append(resCol).append("\n");
        }
        System.out.print(sb);
    }

    private static int dfs(int r, int c) {
        if (r == 0) {
            find = true;
            return c;
        }

        ladder[r][c] = 0;

        for (int dir = 0; dir < 3; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100 && ladder[nr][nc] == 1) {
                int res = dfs(nr, nc);
                if (find)
                    return res;
            }
        }

        return -1;
    }
}