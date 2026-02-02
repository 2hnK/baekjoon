import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            // 원본 암호문의 길이
            int N = Integer.parseInt(br.readLine());

            // 원본 암호문
            ArrayList<String> cipherText = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cipherText.add(st.nextToken());
            }

            // 명령어의 개수
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                if (st.nextToken().equals("I")) {
                    int index = Integer.parseInt(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());

                    List<String> temp = new ArrayList<>();
                    for (int j = 0; j < num; j++) {
                        temp.add(st.nextToken());
                    }

                    cipherText.addAll(index, temp);
                }
            }

            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(cipherText.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}