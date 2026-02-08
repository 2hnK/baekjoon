import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution {
 
    static int N, M, res;
    static int[] conditions;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 재료 수 1~20
            M = Integer.parseInt(st.nextToken()); // 조건 수 0~400
            res = 0;
 
            conditions = new int[M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
 
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
 
                conditions[i] |= (1 << x) | (1 << y);
            }
 
            dfs(1, 0);
 
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        } // tc
        System.out.print(sb);
    }
 
    private static void dfs(int index, int val) {
        // 기저 조건
        if (index == N + 1) {
            boolean flag = true;
            for (int c : conditions) {
                if ((val & c) == c)
                    flag = false;
            }
 
            if (flag)
                res++;
 
            return;
        }
 
        // 탐색
        dfs(index + 1, val); // 비선택
        dfs(index + 1, val | (1 << index)); // 선택
    }
 
}