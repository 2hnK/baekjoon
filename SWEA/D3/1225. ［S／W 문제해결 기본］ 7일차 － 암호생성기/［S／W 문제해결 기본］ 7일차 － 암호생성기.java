import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int T = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[8];
            for (int i = 0; i < 8; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int minValue = Integer.MAX_VALUE;
            for (int x : arr) {
                minValue = Math.min(minValue, x);
            }

            int m = minValue / 15;
            if (minValue % 15 == 0)
                m -= 1;

            Deque<Integer> dq = new ArrayDeque<>();
            for (int n : arr) {
                dq.addLast(n - (m * 15));
            }

            int subtract = 1;
            while (true) {
                int current = dq.pollFirst() - subtract;

                if (current <= 0) {
                    dq.addLast(0);
                    break;
                }

                dq.addLast(current);
                subtract = (subtract % 5) + 1;
            }

            sb.append("#").append(T).append(" ");
            for (int n : dq)
                sb.append(n).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}