import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 0; test_case < 10; test_case++) {
            int T = sc.nextInt();
            ArrayList<Integer> sumList = new ArrayList<>();
            int[][] arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            } // arr 초기화

            calc(arr, sumList);

            sumList.sort(Comparator.reverseOrder());
            int max = sumList.get(0);
            System.out.printf("#%d %d\n", T, max);
        }

    }

    public static void calc(int[][] arr, ArrayList<Integer> sumList) {
        int val = 0;

        // 행의 합
        for (int i = 0; i < 100; i++) {
            val = 0;
            for (int j = 0; j < 100; j++) {
                val += arr[i][j];
            }

            sumList.add(val);
        }

        // 열의 합
        for (int i = 0; i < 100; i++) {
            val = 0;
            for (int j = 0; j < 100; j++) {
                val += arr[j][i];
            }

            sumList.add(val);
        }

        // 대각선(\)의 합
        val = 0;
        for (int i = 0; i < 100; i++) {
            val += arr[i][i];
        }
        sumList.add(val);

        // 대각선(/)의 합
        val = 0;
        for (int i = 99; i <= 0; i--) {
            val += arr[i][99 - i];
        }
        sumList.add(val);
    }
}