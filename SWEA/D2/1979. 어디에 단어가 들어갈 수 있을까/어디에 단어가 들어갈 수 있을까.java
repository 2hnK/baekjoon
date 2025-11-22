import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int TestCase = 1; TestCase <= T; TestCase++) {
			int N = sc.nextInt(); // 배열 크기
			int K = sc.nextInt(); // 단어 길이
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			} // 배열 초기화

			int[] row = new int[N];
			int[] column = new int[N];
			int result = 0;

			for (int i = 0; i < N; i++) {
				int len = 0;
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1)
						len++;
					else {
						if (len == K)
							result++;
						len = 0;
					}
				}
				if (len == K)
					result++;
			}

			for (int j = 0; j < N; j++) {
				int len = 0;
				for (int i = 0; i < N; i++) {
					if (arr[i][j] == 1)
						len++;
					else {
						if (len == K)
							result++;
						len = 0;
					}
				}
				if (len == K)
					result++;
			}
			System.out.printf("#%d %d\n", TestCase, result);
		} // TestCase end
	}
}
