import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int TestCase = 1; TestCase <= T; TestCase++) {
			int P = sc.nextInt(); // A사 1L당 요금
			int Q = sc.nextInt(); // B사 R리터 이하 요금
			int R = sc.nextInt();
			int S = sc.nextInt(); // B사 1L당 요금
			int W = sc.nextInt(); // 사용 수도 양(L)

			int select_A = W * P;

			int select_B = 0;
			if (W <= R) {
				select_B = Q;
			} else {
				select_B = Q + (W - R) * S;
			}

			System.out.printf("#%d %d\n", TestCase, Math.min(select_A, select_B));

		} // TestCase end
	}
}
