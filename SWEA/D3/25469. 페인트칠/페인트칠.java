import java.util.*;

public class Solution {
    static Character[][] map;
    static HashSet<Integer> widthSet;
    static HashSet<Integer> heightSet;
    static int height;
    static int width;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수

        // Run TestCase
        for (int test_case = 0; test_case < T; test_case++) {
            height = sc.nextInt();
            width = sc.nextInt();
            map = new Character[height][width];
            widthSet = new HashSet<>();
            heightSet = new HashSet<>();

            // map 입력: black '#', white '.'
            for (int i = 0; i < height; i++) {
                String line = sc.next();

                for (int j = 0; j < width; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            search();

            int result = heightSet.size() + widthSet.size();
            if(result == height + width)
                result = height > width ? width : height;

            System.out.println(result);
        }
    }

    public static void search() {
        // 행 탐색
        for (int i = 0; i < height; i++) {
            int j;
            for (j = 0; j < width; j++) {
                if (map[i][j] == '.')
                    break;
            }
            if (j == width) {
                heightSet.add(i);
            }
        }

        // 열 탐색
        for (int i = 0; i < width; i++) {
            int j;
            for (j = 0; j < height; j++) {
                if (map[j][i] == '.')
                    break;
            }
            if (j == height) {
                widthSet.add(i);
            }
        }
    }
}
