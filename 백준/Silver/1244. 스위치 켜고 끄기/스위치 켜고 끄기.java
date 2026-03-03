import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, S;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		// ---------솔루션 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine()); // LED 개수

		// 배열 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n;
		}

		S = Integer.parseInt(br.readLine()); // 학생 수
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken()); // 남:1, 여:2
			int num = Integer.parseInt(st.nextToken()); // LED 번호
			a(gender, num);
		}

		// 출력
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i]).append(" ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void a(int gender, int num) {
		// 남자
		if (gender == 1) {
			int k = 1;
			for (int i = num; i < arr.length; i = num * k) {
				arr[i] = (arr[i] + 1) % 2;
				k++;
			}
		}
		// 여자
		else if (gender == 2) {
			int k = 1;

			arr[num] = (arr[num] + 1) % 2;
			while (num - k >= 1 && num + k <= N) {
				if (arr[num - k] == arr[num + k]) {
					arr[num - k] = arr[num + k] = (arr[num - k] + 1) % 2;
					k++;
				} else {
					break;
				}
			}
		}
	}

}
