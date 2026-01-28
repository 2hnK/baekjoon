import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int TC = 1; TC <= T; TC++) {
            sb.append("#" + TC + " ");
            String memory = br.readLine();
            int cnt = 0;

            // 시작값이 1이면 전환
            if (memory.charAt(0) == '1') {
                cnt++;
            }

            // 이전값과 다르면 전환
            for (int i = 1; i < memory.length(); i++) {
                if (memory.charAt(i) == memory.charAt(i - 1)) {
                    continue;
                } else {
                    cnt++;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.print(sb);
    }
}