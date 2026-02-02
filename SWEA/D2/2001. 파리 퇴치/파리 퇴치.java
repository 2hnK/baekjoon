import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] flyMap = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    flyMap[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] sum = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + flyMap[i][j];
                }
            }

            int maxFlies = 0;
            for (int i = M; i <= N; i++) {
                for (int j = M; j <= N; j++) {
                    int areaSum = sum[i][j] - sum[i - M][j] - sum[i][j - M] + sum[i - M][j - M];
                    maxFlies = Math.max(areaSum, maxFlies);
                }
            }

            sb.append("#").append(tc).append(" ").append(maxFlies).append("\n");
        }
        System.out.print(sb);
    }

}
