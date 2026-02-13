import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 수업시간에 교수님 몰래 교실을 나간 상근이 */
public class Main {

    static int N;
    static long totalPairs = 0;
    static long[] count;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        totalPairs = 0;
        count = new long[1024];

        // 비트 카운팅
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            int m = 0;

            while (num > 0) {
                m |= (1 << (num % 10));
                num /= 10;
            }
            count[m]++;
        }

        // 조합 계산
        for (int i = 1; i < 1024; i++) {
            for (int j = i; j < 1024; j++) {
                if ((i & j) > 0) {
                    if (i == j) {
                        totalPairs += (count[i] * (count[i] - 1)) / 2;
                    } else {
                        totalPairs += count[i] * count[j];
                    }
                }
            }
        }
        System.out.print(totalPairs);
    }
}