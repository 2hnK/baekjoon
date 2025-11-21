import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int TestCase = 1; TestCase <= T; TestCase++) {
			int tc = sc.nextInt();
			int[] score = new int[101]; // score: 0~100
			for (int i = 0; i < 1000; i++) { // input: 1000
				score[sc.nextInt()]++;
			} // score init

			int max_frequency = score[0];
			int index = 0;
			for (int i = 1; i <= 100; i++) {
				if (max_frequency < score[i]) {
					max_frequency = score[i];
					index = i;
				} else if (max_frequency == score[i]) {
					index = i;
				}
			} // finding max_frequency, index
			
			System.out.printf("#%d %d\n", tc, index);
		} // TestCase end
	}
}
