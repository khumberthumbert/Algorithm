package problem.Algorithm;

import java.io.*;

/**
 * 1, 2, 3 더하기
 */
public class Main9095 {
    static int dp[] = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[11];

            dp[1] = 1; // 숫자 1을 만드는 방법은 오직 '1' 하나 뿐. -> 방법의 개수 1개
            dp[2] = 2; // 숫자 2를 만드는 방법은 '1+1' 또는 '2' 이다. -> 방법의 개수 2개
            dp[3] = 4; // 숫자 3을 만드는 방법은 '1+1+1', '1+2', '2+1', '3'의 네 가지. -> 방법의 개수 4개

            /**
             * dp[4-1]은 3에 1을 더하는 것을 포함하므로 dp[3]
             * dp[4-2]은 2에 2를 더하는 것을 포함하므로 dp[2]
             * dp[4-3]은 1에 3을 더하는 것을 포함하므로 dp[1]
             */
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            bw.write(dp[n] + "\n");
        }
        bw.flush();
    }
}
