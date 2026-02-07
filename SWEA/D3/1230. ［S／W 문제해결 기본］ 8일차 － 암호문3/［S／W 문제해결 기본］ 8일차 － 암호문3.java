import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {

            int N = Integer.parseInt(br.readLine()); // 암호문의 개수
            ArrayList<String> cypherTexts = new ArrayList<>();

            // 원본 암호문
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cypherTexts.add(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine()); // 명령어의 개수

            // 명령어
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                char c = st.nextToken().charAt(0);
                int x, y;
                String s;
                ArrayList<String> Cyphers;

                switch (c) {
                    case 'I':
                        x = Integer.parseInt(st.nextToken()); // 삽입 위치
                        y = Integer.parseInt(st.nextToken()); // 삽입 개수

                        Cyphers = new ArrayList<>(y);

                        for (int j = 0; j < y; j++) {
                            s = st.nextToken(); // 암호문
                            Cyphers.add(s);
                        }
                        cypherTexts.addAll(x, Cyphers);
                        break;
                    case 'D':
                        x = Integer.parseInt(st.nextToken()); // 삭제 좌표
                        y = Integer.parseInt(st.nextToken()); // 삭제 개수

                        cypherTexts.subList(x, x + y).clear();
                        break;
                    case 'A':
                        y = Integer.parseInt(st.nextToken()); // 추가 개수

                        Cyphers = new ArrayList<>(y); // 암호문

                        for (int j = 0; j < y; j++) {
                            s = st.nextToken();
                            cypherTexts.add(s);
                        }
                        break;
                }
            }
            sb.append("#").append(tc).append(" ");
            for (String s : cypherTexts.subList(0, 10)) {
                sb.append(s).append(" ");
            }
            sb.append("\n");

        } // tc
        System.out.print(sb);
    }

}