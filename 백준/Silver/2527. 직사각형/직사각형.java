import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int x1, y1, p1, q1;
        int x2, y2, p2, q2;
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            p1 = Integer.parseInt(st.nextToken());
            q1 = Integer.parseInt(st.nextToken());

            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            p2 = Integer.parseInt(st.nextToken());
            q2 = Integer.parseInt(st.nextToken());

            if (p1 < x2 || p2 < x1 || y1 > q2 || q1 < y2) {
                sb.append('d' + "\n");
            } else if ((x2 == p1 && y1 == q2) || (x1 == p2 && y1 == q2)
                    || (x2 == p1 && y2 == q1) || (x1 == p2 && y2 == q1)) {
                sb.append('c' + "\n");
            } else if (x2 == p1 || x1 == p2 || y1 == q2 || q1 == y2) {
                sb.append('b' + "\n");
            } else {
                sb.append('a' + "\n");
            }
        }
        System.out.print(sb);
    }
}