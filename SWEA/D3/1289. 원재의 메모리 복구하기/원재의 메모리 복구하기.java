import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int TC = 1; TC <= T; TC++) {
            char[] memory = br.readLine().toCharArray();
            int cnt = 0;
            char currentBit = '0';

            // 이전값과 다르면 전환
            for (char bit : memory) {
                if (bit != currentBit) {
                    cnt++;
                    currentBit = bit;
                }
            }
            sb.append("#" + TC + " " + cnt + "\n");
        }
        System.out.print(sb);
    }
}