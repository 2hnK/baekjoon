import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());

            // 객체 초기화
            Wheel[] wheels = new Wheel[5];
            for (int i = 1; i <= 4; i++) {
                st = new StringTokenizer(br.readLine());
                wheels[i] = new Wheel();

                for (int j = 0; j < 8; j++) {
                    wheels[i].magnet[j] = Integer.parseInt(st.nextToken());
                }
                wheels[i].updateVal(); // r, l값 초기화
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                // 회전 방향 설정
                int[] rotation = new int[5];
                rotation[idx] = dir;

                for (int j = idx; j < 4; j++) {
                    if (wheels[j].rVal != wheels[j + 1].lVal) {
                        rotation[j + 1] = rotation[j] * -1;
                    } else {
                        break;
                    }
                }

                for (int j = idx; j > 1; j--) {
                    if (wheels[j].lVal != wheels[j - 1].rVal) {
                        rotation[j - 1] = rotation[j] * -1;
                    } else {
                        break;
                    }
                }

                // 회전 수행
                for (int j = 1; j <= 4; j++) {
                    wheels[j].rotate(rotation[j]);
                }
            }

            // 스코어 계산
            int sum = 0;
            for (int i = 1; i <= 4; i++) {
                sum += wheels[i].getScore() * (1 << (i - 1));
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
    }

}

class Wheel {
    int[] magnet = new int[8];
    int ptr = 0, rVal = 0, lVal = 0;

    public void rotate(int dir) {
        if (dir == 1) { // 시계 방향
            ptr = (ptr - 1 + 8) % 8;
        }
        if (dir == -1) { // 반시계 방향
            ptr = (ptr + 1) % 8;
        }
        updateVal();
    }

    public int getScore() {
        return (magnet[ptr] == 1) ? 1 : 0;
    }

    public void updateVal() {
        rVal = magnet[(ptr + 2) % 8];
        lVal = magnet[(ptr + 6) % 8];
    }
}