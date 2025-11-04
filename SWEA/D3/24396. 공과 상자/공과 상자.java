import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            int B = sc.nextInt(); // 검은 공, 검은 상자 개수
            int W = sc.nextInt(); // 흰 공, 흰 상자 개수
            int X = sc.nextInt(); // 검~검 점수
            int Y = sc.nextInt(); // 흰~흰 점수
            int Z = sc.nextInt(); // 검~흰 점수
            int score = 0;

            // 두 공의 수가 같은 경우
            if (B == W) {
                if (X + Y > 2*Z)
                    score = (X*B) + (Y*W);
                else
                    score = Z * (B+W);
            }

            // 검은 공이 더 많은 경우
            if (B > W) {
                if (X + Y > 2*Z) // swap: n
                    score = (X*W + Y*W) + (X * (B-W));
                else // swap: y
                    score = (Z*W*2) + (X * (B-W));
            }

            // 흰 공이 더 많은 경우
            if (B < W) {
                if (X + Y > 2*Z)
                    score = (X*B + Y*B) + (Y * (W-B));
                else
                    score = (Z*B*2) + (Y * (W-B));
            }

            System.out.println(score);
        }
    }
}