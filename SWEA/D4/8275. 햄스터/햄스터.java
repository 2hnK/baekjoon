import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, X, M;
    static int[][] conditions;
    static int[] cages, ansCages;
    static int max;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 우리 수
            X = Integer.parseInt(st.nextToken()); // 각 우리의 햄스터 수 0~X
            M = Integer.parseInt(st.nextToken()); // 기록 수
            max = -1;

            conditions = new int[M][3];
            cages = new int[N];
            ansCages = new int[N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                conditions[i][0] = Integer.parseInt(st.nextToken()); // 시작
                conditions[i][1] = Integer.parseInt(st.nextToken()); // 끝
                conditions[i][2] = Integer.parseInt(st.nextToken()); // 마리 수
            }

            dfs(0, 0);

            sb.append("#").append(tc).append(" ");
            if (max == -1) {
                sb.append(-1);
            } else {
                for (int i = 0; i < N; i++) {
                    sb.append(ansCages[i]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int idx, int count) {
        if (idx == N) {
            // 조건 검사
            for (int i = 0; i < M; i++) {
                int sum = 0;
                for (int j = conditions[i][0] - 1; j <= conditions[i][1] - 1; j++) {
                    sum += cages[j];
                }

                if (sum != conditions[i][2]) {
                    return;
                }
            }

            if (count > max) {
                max = count;
                ansCages = cages.clone();
            }
            return;
        }

        // 햄스터 배치
        for (int i = 0; i <= X; i++) {
            cages[idx] = i;
            dfs(idx + 1, count + i);
        }
    }

}