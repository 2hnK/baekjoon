import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, M, C;
    static int[][] honey;
    static int[][] profitMap;
    static int maxProfit;
    static int result;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 벌통 크기
            M = Integer.parseInt(st.nextToken()); // 선택 가능한 벌통의 수
            C = Integer.parseInt(st.nextToken()); // 꿀을 채취할 수 있는 최대 양
            result = 0;

            honey = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    honey[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            profitMap = new int[N][N - M + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    maxProfit = 0;
                    findMax(i, j, 0, 0, 0);
                    profitMap[i][j] = maxProfit;
                }
            }

            for (int r1 = 0; r1 < N; r1++) {
                for (int c1 = 0; c1 <= N - M; c1++) {
                    int w1 = profitMap[r1][c1];

                    for (int r2 = r1; r2 < N; r2++) {
                        for (int c2 = 0; c2 <= N - M; c2++) {
                            if (r1 == r2 && c2 < c1 + M)
                                continue;

                            int w2 = profitMap[r2][c2];
                            result = Math.max(result, w1 + w2);
                        }
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    public static void findMax(int r, int c, int cnt, int sum, int profit) {
        if (sum > C)
            return;

        maxProfit = Math.max(maxProfit, profit);
        if (cnt == M)
            return;

        int current = honey[r][c + cnt];
        findMax(r, c, cnt + 1, sum + current, profit + (current * current)); // 현재 위치 선택
        findMax(r, c, cnt + 1, sum, profit); // 선택 안 함
    }

}