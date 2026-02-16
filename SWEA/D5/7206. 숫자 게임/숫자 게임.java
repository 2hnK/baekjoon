import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 숫자 게임 */
public class Solution {

    static int N, res;
    static int[] memo;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            memo = new int[100000];
            java.util.Arrays.fill(memo, -1);

            res = dfs(N);

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        } // end of tc
        System.out.println(sb);
    }

    /* @Param val: 쪼갤 값 */
    private static int dfs(int value) {
        if (value < 10)
            return 0;

        if (memo[value] != -1) {
            return memo[value];
        }

        String s = String.valueOf(value);
        int len = s.length();
        int max = 0;

        for (int mask = 1; mask < (1 << (len - 1)); mask++) {

            int current = 1;
            int temp = s.charAt(0) - '0';

            for (int i = 0; i < len - 1; i++) {
                if ((mask & (1 << i)) != 0) {
                    current *= temp;
                    temp = s.charAt(i + 1) - '0';
                } else {
                    temp = (temp * 10) + (s.charAt(i + 1) - '0');
                }
            }
            current *= temp;
            max = Math.max(max, dfs(current) + 1); // 서브트리의 최댓값
        }

        return memo[value] = max;
    }

}
/*
 * 주어진 수를 반복적으로 쪼개어 깊이의 최댓값을 구해야 하므로 dfs로 탐색.
 * 쪼갠 수의 크기가 탐색 깊이와 연관이 없으므로 완전탐색.
 * dfs 탐색 시 트리 구조로 탐색이 이루어지므로, 값이 작아질수록 경우의 수가 많아지고 중복된 수가 많으므로 메모이제이션 적용.
 */