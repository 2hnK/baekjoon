import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int TestCase = 1; TestCase <= T; TestCase++) {
			int N = sc.nextInt();
			int arr[][] = new int[N + 1][N + 1];

			arr[0][1] = 1;
			for (int i = 1; i < N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
			}
			System.out.println("#" + TestCase);
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= i + 1; j++) {
					System.out.print(arr[i][j]);
					if (j != i + 1)
						System.out.print(" ");
				}
				System.out.println();
			}
		} // TestCase end
	}
}
