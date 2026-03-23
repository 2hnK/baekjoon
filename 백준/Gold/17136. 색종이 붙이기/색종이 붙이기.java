import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int res;
    static int[] used;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        used = new int[6];

        map = new int[10][10];
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = Integer.MAX_VALUE;
        search(0, 0, 0);

        res = (res == Integer.MAX_VALUE) ? -1 : res;

        System.out.println(res);
    }

    static private void search(int r, int c, int count) {
        if (res <= count)
            return;

        if (r == 10) {
            res = Math.min(res, count);
            return;
        }

        if (c == 10) {
            search(r + 1, 0, count);
            return;
        }

        if (map[r][c] == 1) {
            for (int s = 5; s > 0; s--) {
                if (isPossible(r, c, s) && used[s] < 5) {
                    used[s]++;
                    painting(r, c, s, 0);
                    search(r, c + 1, count + 1);
                    painting(r, c, s, 1);
                    used[s]--;
                }
            }
        } else {
            search(r, c + 1, count);
        }

    }

    static private void painting(int r, int c, int size, int x) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[r + i][c + j] = x;
            }
        }
    }

    static private boolean isPossible(int r, int c, int s) {
        if (r + s > 10 || c + s > 10)
            return false;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                if (map[r + i][c + j] == 0)
                    return false;
            }
        }
        return true;
    }
}
