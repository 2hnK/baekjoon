import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 1;

        for (int TestCase = 1; TestCase <= T; TestCase++) {
            int N = sc.nextInt();
            int[] arr = new int[N];

            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            System.out.println(arr[N/2]);
        }
    }
}
