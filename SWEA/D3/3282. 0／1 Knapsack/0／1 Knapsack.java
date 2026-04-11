import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 3282. 0/1 Knapsack */
public class Solution {

    /* 전역변수 */
    static int K, N, res;
    static int[] V_i, C_i;
    static int[][] memo;

    /* 메인함수 */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 물건의 개수
            K = Integer.parseInt(st.nextToken()); // 가방의 부피

            V_i = new int[N + 1]; // 물건의 부피
            C_i = new int[N + 1]; // 물건의 가치
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                V_i[i] = Integer.parseInt(st.nextToken());
                C_i[i] = Integer.parseInt(st.nextToken());
            }

            memo = new int[N + 1][K + 1]; // memo[index][capacity]
            for (int i = 0; i <= N; i++) {
                Arrays.fill(memo[i], -1);
            }

            res = solve(1, 0);

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        } // End Of TestCase

        System.out.println(sb);
    }

    private static int solve(int index, int capacity) {
        if (index > N) // 인덱스 초과되면 0
        return 0;
        
        if (memo[index][capacity] != -1)
            return memo[index][capacity];
        
        int select = 0;
        if (capacity + V_i[index] <= K)
            select = C_i[index] + solve(index + 1, capacity + V_i[index]);
        int pass = solve(index + 1, capacity);
        
        // System.out.println("index: " + index + ", capacity: " + capacity);
        // System.out.println("select: " + select + ", pass: " + pass);
        return memo[index][capacity] = Math.max(select, pass);
    }

}

/*
 * 물건
 * - 부피 V_i
 * - 가치 C_i
 * 
 * 가방
 * - 최대 부피 K
 * 
 * 물건들 중 몇 개를 선택하여 가방에 넣는다.
 * 이 때 가방에 담을 수 있는 최대 가치를 구하시오.
 */