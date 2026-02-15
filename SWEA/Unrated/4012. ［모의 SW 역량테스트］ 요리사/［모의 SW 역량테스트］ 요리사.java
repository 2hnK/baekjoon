import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 요리사 */
public class Solution {

    static int N, res;;
    static boolean[] visited;
    static int[][] recipes;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine()); // 4~16
            visited = new boolean[N];
            recipes = new int[N][N];
            res = Integer.MAX_VALUE;

            // 조합 점수 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    recipes[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited[0] = true; // 첫 번째 재료는 A 음식에 고정
            select(1, 1);

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        } // end of tc
        System.out.println(sb);
    }

    /* 재료 선택 */
    private static void select(int index, int count) {

        if (count == N / 2) {
            scoring();
            return;
        }

        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                select(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    /* 선택한 재료의 점수 계산 */
    private static void scoring() {

        int scoreA = 0, scoreB = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    scoreA += recipes[i][j] + recipes[j][i];
                } else if (!visited[i] && !visited[j]) {
                    scoreB += recipes[i][j] + recipes[j][i];
                }
            }
        }

        res = Math.min(res, Math.abs(scoreA - scoreB));
    }

}

/*
 * Q. 두 음식의 맛 차이가 최소가 되도록 재료를 배분
 * N/2개의 식재료를 선택한 후 NC2 조합으로 식재료의 맛 점수 계산
 */