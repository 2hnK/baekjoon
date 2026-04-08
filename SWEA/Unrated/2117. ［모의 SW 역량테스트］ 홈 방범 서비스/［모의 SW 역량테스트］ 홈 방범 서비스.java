import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 2117. [모의 SW 역량테스트] 홈 방범 서비스 */
public class Solution {

    /* 전역변수 */
    static int N, M, res;
    static int[][] map;

    /* 메인함수 */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 도시의 크기
            M = Integer.parseInt(st.nextToken()); // 가구의 지불 비용

            int home_cnt = 0;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1)
                        home_cnt++;
                }
            }

            int best_count = 0;
            for (int i = 0; i < N; i++) { // row
                for (int j = 0; j < N; j++) { // col
                    for (int k = 1; k <= N + 1; k++) { // k
                        int cost = k * k + (k - 1) * (k - 1);
                        int count = search(i, j, k);
                        int profit = (M * count) - cost;

                        if (profit >= 0) {
                            best_count = Math.max(best_count, count);
                        }

                        if (best_count == home_cnt)
                            break;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(best_count).append("\n");
        } // End Of TestCase

        System.out.println(sb);
    }

    private static int search(int r, int c, int k) {
        int count = 0;
        for (int i = r - (k - 1); i <= r + (k - 1); i++) {
            for (int j = c - (k - 1); j <= c + (k - 1); j++) {
                if (i < 0 || i >= N || j < 0 || j >= N)
                    continue;

                if (Math.abs(i - r) + Math.abs(j - c) < k) {
                    if (map[i][j] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
