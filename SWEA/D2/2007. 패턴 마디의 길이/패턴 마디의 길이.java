import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int TestCase = 1; TestCase <= T; TestCase++) {
			String line = sc.next();
			String pattern = "";
			int max_length = 10;
			int answer = 0;

			for (int len = 1; len <= max_length; len++) {
				pattern = line.substring(0, len);
				boolean flag = true;

				for (int j = 0; j + len < line.length(); j += len) {
					if (!line.substring(j, j + len).equals(pattern)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					answer = len;
					break;
				}
			}

			System.out.printf("#%d %d\n", TestCase, answer);
		} // TestCase end
	}
}
