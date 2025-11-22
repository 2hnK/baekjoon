import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int TestCase = 1; TestCase <= T; TestCase++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String line = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = line.charAt(j) - '0';
				}
			}

			int s, e;
			int m = (N / 2);
			int res = 0;
			for (int i = 0; i < N; i++) {
				int dist = m - Math.abs(m - i);
				s = m - dist;
				e = m + dist;

				for (int j = s; j <= e; j++) {
					res += arr[i][j];
				}
			}
			System.out.printf("#%d %d\n", TestCase, res);
		} // TestCase end
	}
}
