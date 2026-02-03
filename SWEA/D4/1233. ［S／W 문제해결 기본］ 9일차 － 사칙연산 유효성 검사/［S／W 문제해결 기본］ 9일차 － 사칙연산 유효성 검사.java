import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            int res = 1;

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 노드 번호
                char nodeVal = st.nextToken().charAt(0);

                if (i * 2 <= N) {
                    if (Character.isDigit(nodeVal)) {
                        res = 0;
                    }
                } else {
                    if (!Character.isDigit(nodeVal)) {
                        res = 0;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        } // end of tc
        System.out.print(sb);
    }
}
