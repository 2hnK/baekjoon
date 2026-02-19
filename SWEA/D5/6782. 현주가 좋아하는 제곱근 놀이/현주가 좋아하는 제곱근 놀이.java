import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 현주가 좋아하는 제곱근 놀이 */
public class Solution {

    static long N;
    static int res;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Long.parseLong(br.readLine());
            res = 0;

            calc(N, 0);

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        } // end of tc
        System.out.println(sb);
    }

    /* @Param val: 현재 값, count: 연산 횟수 */
    private static void calc(long val, int count) {
        if (val == 2) {
            res = count;
            return;
        }

        double sqrt = Math.sqrt(val);
        long next = (long) Math.pow((long) (sqrt + 1), 2); // 다음 완전제곱근 값
        int add = (int) (next - val);

        if (sqrt == (long) sqrt) {
            calc((long) sqrt, count + 1);
        } else if (sqrt > (long) sqrt) {
            calc((long) sqrt + 1, count + add + 1);
        }
    }

}
/*
 * 주어진 수를 제곱근과 +1 덧셈을 통해 2를 만드려면 N이상의 가장 근접한 $n^2$인 값을 찾아서 제곱근을 처리하는 과정을 반복하여 해를
 * 구할 수 있다. 따라서 주어진 값에 제곱근을 처리한 결과의 정수부에+1한 다음 제곱한 값까지 필요한 거리를 더한 후 제곱근을 처리하는
 * 과정을 반복수행한다.
 */