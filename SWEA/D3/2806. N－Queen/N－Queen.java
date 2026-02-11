import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static int N, totalCnt;
    static boolean[] col, slash, bSlash;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine()); // 1~10
            totalCnt = 0;

            col = new boolean[N + 1];
            slash = new boolean[2 * N + 1];
            bSlash = new boolean[2 * N + 1];

            setQueen(1);

            sb.append("#").append(tc).append(" ").append(totalCnt).append("\n");
        } // end of tc
        System.out.println(sb);
    }

    private static void setQueen(int row) {
        if (row > N) {
            totalCnt++;
            return;
        }

        for (int c = 1; c <= N; c++) {
            // [row][c] 두는 것이 가능한지 확인
            if (col[c] || slash[row + c] || bSlash[(row - c) + N])
                continue;

            col[c] = slash[row + c] = bSlash[(row - c) + N] = true;
            setQueen(row + 1);
            col[c] = slash[row + c] = bSlash[(row - c) + N] = false;
        }
    }
}