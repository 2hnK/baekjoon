import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {

	static Set<Integer>[] visited;
	static int max, changeCnt;
	static char[] digits;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			digits = st.nextToken().toCharArray(); // 숫자판
			changeCnt = Integer.parseInt(st.nextToken()); // 교환 횟수

			max = 0;
			
			visited = new HashSet[changeCnt + 1]; // 메모이제이션
			for (int i = 0; i <= changeCnt; i++) {
				visited[i] = new HashSet<>();
			}

			dfs(0, digits);

			sb.append("#").append(tc + 1).append(" ").append(max).append("\n");
		}

		System.out.println(sb.toString());

	} // end of tc

	public static void dfs(int depth, char[] digits) {
		int current = toInt(digits);

		if (depth == changeCnt) {
			max = Math.max(max, current);
			return;
		}

		if (!visited[depth].add(current)) {
			return;
		}

		// 백트래킹
		for (int i = 0; i < digits.length - 1; i++) {
			for (int j = i + 1; j < digits.length; j++) {
				swap(digits, i, j);
				dfs(depth + 1, digits);
				swap(digits, i, j);
			}
		}

	}

	// char[] to int
	public static int toInt(char[] digits) {
		return Integer.parseInt(new String(digits));
	}

	// swap character elements
	public static void swap(char[] digits, int x, int y) {
		char temp = digits[x];
		digits[x] = digits[y];
		digits[y] = temp;
	}

}
