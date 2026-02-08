import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 햄버거 다이어트(부분집합) */
public class SWEA_5215_subset {

    static int N, L, best_score;
    static int[][] grad;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 재료의 수
            L = Integer.parseInt(st.nextToken()); // 제한 칼로리
            best_score = 0;

            grad = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                grad[i][0] = Integer.parseInt(st.nextToken()); // 점수
                grad[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
            }

            dfs(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(best_score).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int idx, int score, int kcal) {
        if (idx == N) {
            best_score = Math.max(best_score, score);
            return;
        }

        if (kcal + grad[idx][1] <= L)
            dfs(idx + 1, score + grad[idx][0], kcal + grad[idx][1]);

        dfs(idx + 1, score, kcal);
    }
}
/*
 * 제한된 칼로리 내에서 최고점을 찾기
 */