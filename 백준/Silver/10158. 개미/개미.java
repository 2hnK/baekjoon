import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int T = Integer.parseInt(br.readLine());

        int finalX = (C + T) % (2 * W);
        if (finalX > W) {
            finalX = 2 * W - finalX;
        }

        int finalY = (R + T) % (2 * H);
        if (finalY > H) {
            finalY = 2 * H - finalY;
        }

        System.out.println(sb.append(finalX).append(" ").append(finalY));

    }
}