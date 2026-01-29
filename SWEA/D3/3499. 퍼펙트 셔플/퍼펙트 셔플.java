import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            String[] cards = new String[N];
            for (int i = 0; i < N; i++) {
                cards[i] = st.nextToken();
            } // init array

            String[] shuffle = new String[N];
            int c = (N + 1) / 2;
            for (int i = 0; i < c; i++) {
                shuffle[i * 2] = cards[i];
            }

            for (int i = c; i < N; i++) {
                shuffle[(i - c) * 2 + 1] = cards[i];
            }

            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < N; i++) {
                sb.append(shuffle[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
