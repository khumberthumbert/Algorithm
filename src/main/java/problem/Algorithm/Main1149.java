package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1149 {

    /**
     * 배열 인덱스를 명확하게 하기 위해 각각 0,1,2로 정의한 것.
     */
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;
    static int[][] Cost; // 비용 저장할 배열
    static int[][] DP; // DP테이블을 저장할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N -> 집의 수
        int N = Integer.parseInt(br.readLine());

        /**
         * 각 집의 색상별 비용을 저장할 공간을 할당.
         */
        Cost = new int[N][3];
        DP = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            /**
             * 각 집의 색상별 비용을 입력받아 Cost배열에 저장
             */
            Cost[i][Red] = Integer.parseInt(st.nextToken());
            Cost[i][Green] = Integer.parseInt(st.nextToken());
            Cost[i][Blue] = Integer.parseInt(st.nextToken());
        }
        //DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
        DP[0][Red] = Cost[0][Red];
        DP[0][Green] = Cost[0][Green];
        DP[0][Blue] = Cost[0][Blue];

        //마지막 집을 각각 빨강, 초록, 파랑으로 칠하는 최소 비용을 계산하여 출력. Math.min을 사용하여 세 색상 중 최소 비용을 선택한다.
        System.out.println(Math.min(Paint_cost(N-1, Red), Math.min(Paint_cost(N-1, Green), Paint_cost(N -1 , Blue))));
    }

    /**
     * N번쨰 집을 color 색상으로 칠하는 최소 비용을 계산하는 함수.
     */
    static int Paint_cost(int N, int color) {

        //만약 탐색하지 않은 배열이라면
        if (DP[N][color] == 0) {

            //color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
            /**
             * 각 생상에 대해 이전 집들을 다른 색상으로 칠하는 최소 비용을 계산하고, 현재 집을 해당 색상으로 칠하는 비용을 더한다. 이를 'DP'배열에 저장.
             * ex) 현재 집을 빨강으로 칠할 떄, 이전 집을 초록 또는 파랑으로 칠하는 최소 비용에 현재 집을 빨강으로 칠하는 비용을 더한다.
             */
            if(color == Red) {
                DP[N][Red] = Math.min(Paint_cost(N - 1, Green), Paint_cost(N - 1, Blue)) + Cost[N][Red];
            } else if (color == Green) {
                DP[N][Green] = Math.min(Paint_cost(N - 1, Red), Paint_cost(N - 1, Blue)) + Cost[N][Green];
            } else{
                DP[N][Blue] = Math.min(Paint_cost(N - 1, Red), Paint_cost(N - 1, Green)) + Cost[N][Blue];
            }
        }
        return DP[N][color];
    }
}
