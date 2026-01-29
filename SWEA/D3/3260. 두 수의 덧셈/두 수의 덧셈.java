import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;
            int sum = 0;

            StringBuilder calSb = new StringBuilder();
            while (i >= 0 || j >= 0 || carry > 0) {
                sum = carry;
                if (i >= 0)
                    sum += a.charAt(i--) - '0';
                if (j >= 0)
                    sum += b.charAt(j--) - '0';

                calSb.append(sum % 10);
                carry = sum / 10;
            }

            sb.append("#").append(tc).append(" ").append(calSb.reverse()).append("\n");
        }
        System.out.print(sb);
    }
}