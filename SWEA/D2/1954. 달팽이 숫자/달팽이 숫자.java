import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int TestCase = 1; TestCase <= T; TestCase++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int[] dr = { 0, 1, 0, -1 }; // 우하좌상
			int[] dc = { 1, 0, -1, 0 };
			int r = 0, c = 0, d = 0;

			for (int num = 1; num <= N * N; num++) {
				arr[r][c] = num;
				int nr = r + dr[d]; // nr: next row
				int nc = c + dc[d]; // nc: next column
				if (!(nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0)) {
					d = (d + 1) % 4;
					nr = r + dr[d];
					nc = c + dc[d];
				}
				r = nr;
				c = nc;
			}

			System.out.printf("#%d\n", TestCase);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]);
					if (!(j == N - 1)) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		} // TestCase end
	}
}
