import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] cond = new int[4]; // A C G T
    static int[] cnt = new int[4];
    static int res = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이

        String s = br.readLine();
        st = new StringTokenizer(br.readLine());

        // 조건 배열 초기화
        for (int i = 0; i < 4; i++) {
            cond[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 윈도우 설정
        for (int i = 0; i < P; i++) {
            increase(s.charAt(i));
        }

        // 슬라이딩 윈도우
        for (int i = 0; i <= S - P; i++) {
            if (isValid()) res++;

            if (i < S - P) {
                decrease(s.charAt(i));
                increase(s.charAt(i + P));
            }
        }

        System.out.println(res);
    }

    private static void increase(char c) {
        switch (c) {
            case 'A': cnt[0]++; break;
            case 'C': cnt[1]++; break;
            case 'G': cnt[2]++; break;
            case 'T': cnt[3]++; break;
        }
    }

    private static void decrease(char c) {
        switch (c) {
            case 'A': cnt[0]--; break;
            case 'C': cnt[1]--; break;
            case 'G': cnt[2]--; break;
            case 'T': cnt[3]--; break;
        }
    }

    private static boolean isValid() {
        for (int i = 0; i < 4; i++) {
            if (cnt[i] < cond[i]) return false;
        }
        
        return true;
    }
}