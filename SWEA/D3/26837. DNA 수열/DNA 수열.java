import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            int a_t = 0;
            int c_g = 0;
            long result = 0;

            Map<String, Integer> map = new HashMap<>();

            map.put("0,0", 1);

            for (char c : str.toCharArray()) {
                // 누적합 계산
                if (c == 'A')
                    a_t++;
                else if (c == 'T')
                    a_t--;
                else if (c == 'C')
                    c_g++;
                else if (c == 'G')
                    c_g--;

                String key = a_t + "," + c_g;

                int count = map.getOrDefault(key, 0);
                result += count;

                map.put(key, count + 1);
            }

            System.out.println(result);

        } // end of tc
    }
}