import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 마지막 조별 시합 */
public class Main {

    static int N, D, K, max;
    static int[] students, quiz;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생 수
        D = Integer.parseInt(st.nextToken()); // 문제 종류 (1~15)
        K = Integer.parseInt(st.nextToken()); // 서로 다른 문제 수 (1~D)
        students = new int[N];
        quiz = new int[D + 1];
        max = 0;

        // 학생 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int canSolve = Integer.parseInt(st.nextToken());

            // 학생이 푼 문제 유형 비트마스킹
            for (int j = 0; j < canSolve; j++) {
                int q = Integer.parseInt(st.nextToken());
                students[i] |= (1 << q);
            }
        }

        search(1, 0, 0);

        System.out.print(max);
    } // end of main

    private static void search(int index, int select, int mask) {
        if (index > D || select == K) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if ((students[i] & ~mask) == 0) {
                    cnt++;
                }
            }
            max = Math.max(cnt, max);
            return;
        }

        // 남은 문제로 K개를 채울 수 없으면 리턴
        if (D - index + 1 < K - select) {
            return;
        }

        for (int i = index; i <= D; i++) {
            search(i + 1, select + 1, mask | (1 << i)); // i번 유형 선택
        }
    } // end of search()

}