import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] arr = new boolean[100][100];
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = y; j < y + 10; j++) {
                for (int k = x; k < x + 10; k++) {
                    if (arr[j][k] != true) {
                        arr[j][k] = true;
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
