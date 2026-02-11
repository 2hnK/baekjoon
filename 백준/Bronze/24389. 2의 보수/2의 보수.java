import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 2의 보수 */
public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int x = ~N + 1;
        int y = x ^ N;
        int cnt = 0;

        for (char c : Integer.toBinaryString(y).toCharArray()) {
            if (c == '1')
                cnt++;
        }

        System.out.print(cnt);
    }

}