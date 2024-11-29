package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main1463 {

    static Integer[] dp; //

    //함점 : 무조건 큰 수로 나눈다고 해결되지 않는다.
    static int recur(int N) {
        if (dp[N] == null) {
            //6으로 나눠지는 경우 -> 2와 3의 배수 즉 6으로 나눠지는 경우.
            if (N % 6 == 0) {
                dp[N] = Math.min(recur(N-1), Math.min(recur(N/3), recur(N/2))) + 1;
            }
            //3으로만 나눠지는 경우
            else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }
            //2로만 나눠지는 경우
            else if(N % 2 == 0) {
                dp[N] = Math.min(recur(N/2), recur(N -1)) + 1;
            }
            //2와 3으로 나눠어지지 않는경우
            else {
                dp[N] = recur(N -1) + 1;
            }
        }
        return dp[N];
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        /**
         * N이 1 일 때 연산 횟수는 0 이다. 그래서 0 넣는겨.
         * dp[1]=0; 이것은 문제의 정의에 따른 것. N=1이 이미 목표 상태이기 때문에 '1'을 '1'로 만드는 데 필요한 연산 횟수는 '0'이다. 즉, 아무런 작업도 필요하지 않으므로 0이다.
         * dp[0]=0; 이 설정은 관습과 일관성 유지, 잠재적 에러를 방지하기 위해 초기화 하는 것.
         */
        dp[0] = dp[1] = 0;

        System.out.println(recur(N));
    }
}
