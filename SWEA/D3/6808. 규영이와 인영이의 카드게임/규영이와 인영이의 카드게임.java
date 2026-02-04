import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static final int TOTAL_CARDS = 18;
    static final int HALF_CARDS = TOTAL_CARDS / 2;
    static int kyuWinCount, kyuLoseCount;
    static int[] kyuCards;
    static int[] inCards;
    static boolean[] kyuVisited;
    static boolean[] inVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            inCards = new int[HALF_CARDS + 1];
            kyuCards = new int[HALF_CARDS + 1];
            kyuVisited = new boolean[TOTAL_CARDS + 1];
            inVisited = new boolean[HALF_CARDS + 1];
            kyuWinCount = 0;
            kyuLoseCount = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 규영이 카드 입력
            for (int i = 1; i <= HALF_CARDS; i++) {
                int num = Integer.parseInt(st.nextToken());
                kyuCards[i] = num;
                kyuVisited[num] = true;
            }

            // 인영이 카드 구성 
            int[] restCards = new int[HALF_CARDS + 1];
            int idx = 1;
            for (int i = 1; i <= TOTAL_CARDS; i++) {
                if (!kyuVisited[i]) {
                    restCards[idx++] = i;
                }
            }

            draw(1, inCards, restCards);

            sb.append("#").append(tc).append(" ").append(kyuWinCount).append(" ").append(kyuLoseCount)
                    .append("\n");
        }

        System.out.print(sb);
    }

    private static void draw(int round, int[] inCards, int[] restCards) {
        // 기저 조건
        if (round == 10) {
            play(inCards);
            return;
        }

        // 인영이 카드 뽑기
        for (int i = 1; i <= HALF_CARDS; i++) {
            if (!inVisited[i]) {
                inCards[round] = restCards[i];
                inVisited[i] = true;

                draw(round + 1, inCards, restCards);

                inVisited[i] = false;
            }
        }
    }

    private static void play(int[] inCards) {
        int inScore = 0;
        int kyuScore = 0;

        // 점수 계산
        for (int i = 1; i <= HALF_CARDS; i++) {
            if (inCards[i] > kyuCards[i])
                inScore += inCards[i] + kyuCards[i];
            else
                kyuScore += inCards[i] + kyuCards[i];
        }

        // 승패 카운트
        if (inScore < kyuScore) {
            kyuWinCount++;
        } else if (inScore > kyuScore) {
            kyuLoseCount++;
        }
    }
}
