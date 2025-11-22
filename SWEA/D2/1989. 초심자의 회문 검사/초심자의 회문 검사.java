import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int TestCase = 1; TestCase <= T; TestCase++) {
			String word = sc.next();
			String reverse = "";
			
			for (int i = word.length() - 1; i >= 0; i--) {
				reverse += word.charAt(i);
			}
			int res = 0;
			if (word.equals(reverse))
				res = 1;

			System.out.printf("#%d %d\n", TestCase, res);
		} // TestCase end
	}
}
