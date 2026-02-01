import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이

        String s = br.readLine().replace('A', '0').replace('C', '1').replace('G', '2').replace('T', '3');
        int[] cond = new int[4]; // A C G T
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cond[i] = Integer.parseInt(st.nextToken());
        } // 조건 배열 초기화

        int[] cnt = new int[4];
        for (int i = 0; i < P; i++) {
            cnt[s.charAt(i) - '0']++;
        } // 시작 부분 문자열 조건 계산

        int res = 0;
        for (int i = 0; i < S - P + 1; i++) {
            if (cnt[0] >= cond[0] && cnt[1] >= cond[1] && cnt[2] >= cond[2] && cnt[3] >= cond[3]) {
                res++;
            }
            if (i < S - P) {
                cnt[s.charAt(i) - '0']--;
                cnt[s.charAt(P + i) - '0']++;
            }
        } // 슬라이딩 윈도우

        System.out.println(res);
    }
}