import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(br.readLine());
        final int MAP_SIZE = H * W;

        Sticker[] stickers = new Sticker[count];
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            stickers[i] = new Sticker(r, c);
        }

        int ans = 0;
        for (int i = 0; i < stickers.length; i++) {
            for (int j = i + 1; j < stickers.length; j++) {
                Sticker a = stickers[i];
                Sticker b = stickers[j];
                int size = a.size + b.size;

                if (size > MAP_SIZE || size <= ans)
                    continue;

                if (canPlace(a, b, H, W)) {
                    ans = Math.max(ans, size);
                }
            }
        }

        System.out.println(ans);
    }

    public static boolean canPlace(Sticker a, Sticker b, int H, int W) {
        for (int x = 0; x < 2; x++) {
            int ar = x == 0 ? a.r : a.c;
            int ac = x == 0 ? a.c : a.r;

            for (int y = 0; y < 2; y++) {
                int br = y == 0 ? b.r : b.c;
                int bc = y == 0 ? b.c : b.r;

                // 세로 배치
                if (ar + br <= H && Math.max(ac, bc) <= W)
                    return true;

                // 가로 배치
                if (ac + bc <= W && Math.max(ar, br) <= H)
                    return true;
            }
        }

        return false;
    }

    public static class Sticker {
        int r;
        int c;
        int size;

        public Sticker(int r, int c) {
            this.r = r;
            this.c = c;
            this.size = r * c;
        }
    }
}