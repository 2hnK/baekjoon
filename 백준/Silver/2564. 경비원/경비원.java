import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken()); // 가로 길이
        int H = Integer.parseInt(st.nextToken()); // 세로 길이
        int SHOP_COUNT = Integer.parseInt(br.readLine());

        // [1북 2남 3서 4동]
        Node[] nodes = new Node[SHOP_COUNT + 1];
        for (int i = 0; i <= SHOP_COUNT; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            switch (dir) {
                case 1: // 북
                    nodes[i] = new Node(dist, H, 1);
                    break;
                case 2: // 남
                    nodes[i] = new Node(dist, 0, 2);
                    break;
                case 3: // 서
                    nodes[i] = new Node(0, H - dist, 3);
                    break;
                case 4: // 동
                    nodes[i] = new Node(W, H - dist, 4);
                    break;
            }
        }

        Node guard = (Node) nodes[SHOP_COUNT];
        int res = 0;
        for (int i = 0; i < SHOP_COUNT; i++) {
            Node shop = nodes[i];

            if (guard.dir == shop.dir) { // 동일한 방향
                res += Math.abs(shop.x - guard.x) + Math.abs(shop.y - guard.y);
            } else if (shop.dir + guard.dir == 3) { // 북, 남
                int dist1 = shop.x + guard.x + H;
                int dist2 = (W - shop.x) + (W - guard.x) + H;
                res += Math.min(dist1, dist2);
            } else if (shop.dir + guard.dir == 7) { // 서, 동
                int dist1 = (H - shop.y) + (H - guard.y) + W;
                int dist2 = shop.y + guard.y + W;
                res += Math.min(dist1, dist2);
            } else { // 직각 방향
                res += Math.abs(shop.x - guard.x) + Math.abs(shop.y - guard.y);
            }
        }

        System.out.println(res);
    }
}

class Node {
    int x;
    int y;
    int dir;

    public Node(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}