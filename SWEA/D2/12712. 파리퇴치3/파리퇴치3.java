import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = getMaxSpray(arr, N, M);
            System.out.println("#" + tc + " " + ans);
        }
    }

    static int getMaxSpray(int[][] a, int N, int M) {
        int k = M - 1;
        int best = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                best = Math.max(best, plusSum(a, N, r, c, k));
                best = Math.max(best, xSum(a, N, r, c, k));
            }
        }
        return best;
    }

    static int plusSum(int[][] a, int N, int r, int c, int k) {
        int sum = a[r][c];

        int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
        int[] dc = {0, 0, -1, 1};

        for (int d = 1; d <= k; d++) {
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir] * d;
                int nc = c + dc[dir] * d;
                if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                    sum += a[nr][nc];
                }
            }
        }
        return sum;
    }

    static int xSum(int[][] a, int N, int r, int c, int k) {
        int sum = a[r][c];

        int[] dr = {-1, -1, 1, 1}; // 좌상 우상 좌하 우하
        int[] dc = {-1, 1, -1, 1};

        for (int d = 1; d <= k; d++) {
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir] * d;
                int nc = c + dc[dir] * d;
                if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                    sum += a[nr][nc];
                }
            }
        }
        return sum;
    }
}
