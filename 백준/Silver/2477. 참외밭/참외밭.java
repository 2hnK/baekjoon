import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int[] dir = new int[6];
        int[] dist = new int[6];
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            dir[i] = Integer.parseInt(st.nextToken());
            dist[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0, blockSize = 0, width = 0, height = 0;
        for (int i = 0; i < 6; i++) {
            if (dir[i] == 4)
                width += dist[i];
            if (dir[i] == 1)
                height += dist[i];

            int x1 = dir[i];
            int x2 = dir[(i + 1) % 6];
            if ((x1 == dir[(i + 2) % 6]) && (x2 == dir[(i + 3) % 6])) {
                blockSize = dist[(i + 1) % 6] * dist[(i + 2) % 6];
            }

            result = ((width * height) - blockSize) * K;
        }

        System.out.print(result);
    }
}