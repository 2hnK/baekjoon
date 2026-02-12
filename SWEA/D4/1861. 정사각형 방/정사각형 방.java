import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 정사각형 방 */
public class Solution {

    static int N;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int[][] map, memo; // memo[r][c]: (r,c)에서 출발 시 이동 가능한 방의 수

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            memo = new int[N][N];

            // 맵 초기화
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxCount = 0;
            int startRoom = Integer.MAX_VALUE;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int count = dfs(r, c);
                    // 더 긴 경로이거나, 같은 길이일 때 시작 방 번호가 더 작으면 갱신
                    if (count > maxCount || (count == maxCount && map[r][c] < startRoom)) {
                        maxCount = count;
                        startRoom = map[r][c];
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(startRoom)
                    .append(" ").append(maxCount).append("\n");
        } // end of tc
        System.out.println(sb);
    }

    private static int dfs(int r, int c) {
        // 이미 계산된 경우 재사용
        if (memo[r][c] != 0)
            return memo[r][c];

        memo[r][c] = 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                continue;

            if (map[nr][nc] == map[r][c] + 1) {
                memo[r][c] = 1 + dfs(nr, nc);
                break;
            }
        }

        return memo[r][c];
    }

}
/*
 * Q. 인접한 숫자의 방으로만 이동할 수 있을 때, 가장 많은 방을 이동할 수 있는지 구하는 문제.
 * - 각 방은 [1, N*N] 범위로 구성되어 있어, 단방향 이동만 가능하다.
 * - DFS를 활용하여 각 방에서 출발했을 때 이동할 수 있는 최대 방의 수를 계산하고,
 * 메모이제이션을 통해 이미 계산된 방의 경우 재사용하여 시간을 단축시켰다.
 */