package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//체스판 다시 칠하기
public class Main1018 {

    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];

        //체스판 색 입력 받기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true; // W일 때는 true
                } else {
                    arr[i][j] = false; // B일 때는 false
                }
            }
        }

        //8*8 체스판을 검사할 부분 범위 설정.
        int N_row = N - 7;
        int M_col = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y) {
        //현재 시작 지점 행, 열 에서 8칸씩 더하여 끝 지점을 계산 하는 것.
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean TF = arr[x][y]; // 첫 번째 칸의 색

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {

                // 올바른 색이 아닐 경우 count 1 증가
                if (arr[i][j] != TF) {
                    count++;
                }
                // 다음 칸 색 바뀌어야 하니까 true라면 false로, false라면 true로 변경
                TF = (!TF);
            }
            TF = !TF;
        }
        /* 첫번째 칸을 기준으로 할 때의 색칠할 개수와,
        첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의 색칠할 개수 ( 64-count) 중 최솟값을 count에 저장
         */
        count = Math.min(count, 64 - count);

        //이전까지의 경우 중 최솟값보다 현재 count 값이 더 작을 경우 최솟값을 갱신
        min = Math.min(min, count);
    }
}
