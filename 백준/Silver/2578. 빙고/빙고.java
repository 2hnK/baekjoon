import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rowPos = new int[26];
        int[] colPos = new int[26];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(st.nextToken());
                rowPos[val] = i;
                colPos[val] = j;
            }
        } // init array

        int[] rowCnt = new int[5];
        int[] colCnt = new int[5];
        int bingo = 0;
        int turn = 0;
        int diag1 = 0;
        int diag2 = 0;
        outer: for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                turn++;
                int val = Integer.parseInt(st.nextToken());
                int r = rowPos[val];
                int c = colPos[val];

                rowCnt[r]++;
                colCnt[c]++;

                if (rowCnt[rowPos[val]] == 5)
                    bingo++;
                if (colCnt[colPos[val]] == 5)
                    bingo++;
                if (r == c) {
                    diag1++;
                    if (diag1 == 5)
                        bingo++;
                }
                if (r + c == 4) {
                    diag2++;
                    if (diag2 == 5)
                        bingo++;
                }
                if (bingo >= 3)
                    break outer;
            }

        } // bingo game

        System.out.println(turn);
    }
}
