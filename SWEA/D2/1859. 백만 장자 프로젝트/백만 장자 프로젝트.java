import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int TestCase = 1; TestCase <= T; TestCase++) {
			int N = sc.nextInt(); // day count
			int[] prices = new int[N];

			for (int i = 0; i < N; i++) {
				prices[i] = sc.nextInt();
			}

			long max = 0;
			long temp = 0;
			long res = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (prices[i] > max) { // 정산
					res += temp;
					temp = 0;
					max = prices[i];
				}

				else {
					temp += max - prices[i];
					if (i == 0)
						res += temp;
				}
			}

			System.out.printf("#%d %d\n", TestCase, res);
		} // TestCase end
	}
}
