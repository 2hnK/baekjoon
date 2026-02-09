import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 숫자 만들기 */
public class Solution {

    static int MAX, MIN, N;
    static int[] operations, numbers;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            // 값 초기화
            N = Integer.parseInt(br.readLine());
            MAX = Integer.MIN_VALUE;
            MIN = Integer.MAX_VALUE;

            operations = new int[4];
            numbers = new int[N];

            // 연산자 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                operations[i] = Integer.parseInt(st.nextToken());
            }

            // 피연산자 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            // dfs 순회
            dfs(0, numbers[0]);

            sb.append("#").append(tc).append(" ").append(MAX - MIN).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int cnt, int res) {
        // MAX, MIN 갱신
        if (cnt == N - 1) {
            MAX = Math.max(MAX, res);
            MIN = Math.min(MIN, res);
        }

        // 연산자 탐색 (+-*/)
        for (int i = 0; i < 4; i++) {
            if (operations[i] > 0) {
                operations[i]--;
                dfs(cnt + 1, calc(res, numbers[cnt + 1], i));
                operations[i]++;
            }
        }
    }

    private static int calc(int x, int y, int op) {
        switch (op) {
            case 0: return x + y;
            case 1: return x - y;
            case 2: return x * y;
            case 3: return x / y;
        }
        return 0;
    }
}