package problem.Algorithm;

import java.io.*;

//월드컵
public class Main6987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static long result;

    //총 15개의 경기 조합, 각 배열 요소는 두 팀의 인덱스를 가짐.
    //ex) {0, 1}은 팀 0과 팀 1의 경기를 의미
    static int[][] matchUp = {
            {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5},
            {1, 2}, {1, 3}, {1, 4}, {1, 5},
            {2, 3}, {2, 4}, {2, 5},
            {3, 4}, {3, 5},
            {4, 5}
    };

    public static void main(String[] args) throws IOException {
        for (int tc = 0; tc < 4; tc++) {
            result = Long.parseLong(br.readLine().replaceAll(" ", ""));

            //result와 일치하는 결과가 있는지 확인한다.
            sb.append(solve(0, 0) ? "1 " : "0 ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    //n: 현재까지 확인한 경기 수, state 현재 상태를 숫자로 표현한 값.
    public static boolean solve(int n, long state) {
        //재귀 종료 조건. n이 15(즉, 모든 경기를 다 확인한 경우)이면 state가 result와 같은지 여부를 반환한다.
        if(n== matchUp.length) return state == result;
        //state가 result보다 커지면 더 이상 탐색할 필요가 없으므로 false 반환하고 재귀호출 종료한다.
        if(state > result) return false;

        //현재 경기 쌍에서 두 팀의 인덱스 값을 A와 B에 저장한다.
        int A = matchUp[n][0];
        int B = matchUp[n][1];
        return solve(n + 1, state + 100 * powerOfTen(A) + powerOfTen(B)) // win
            || solve(n + 1, state + 10 * powerOfTen(A) + 10 * powerOfTen(B)) // draw
            || solve(n + 1, state + powerOfTen(A) + 100 * powerOfTen(B)); // lose
    }

    public static long powerOfTen(int n) {
        return (long) Math.pow(10, 15 - n * 3);
    }
}
