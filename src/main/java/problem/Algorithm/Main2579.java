package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579 {

    static Integer dp[];
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1]; // dp -> 각 계단의 최대 점수를 저장 dp[i] -> i번 째 계단까지의 최대 점수를 의미.
        arr = new int[N + 1]; // 각 계단의 점수를 저장 arr[i] -> i 번째 계단의 점수를 의미.

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //이 부분이 dp 활용이군.
        dp[0] = arr[0];	// 디폴트값이 null이므로 0으로 초기화 해주어야한다.
        dp[1] = arr[1];

        if(N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(N));

    }

    /** 예시: 계단 점수 10, 20, 15, 25, 10, 20이고, N = 6
     * find(6) 호출:
     *  dp[6]이 null이므로 계산을 시작합니다.
     *  두 가지 경우를 고려합니다:
     *          find(4) (즉, N-2번째 계단에서 오는 경우)
     *          find(3) + arr[5] (즉, N-3번째 계단을 거쳐 N-1번째 계단을 거쳐 오는 경우)
     *      따라서 find(6)은 find(4)를 먼저 호출합니다.
     *
     * find(4) 호출:
     *  dp[4]이 null이므로 계산을 시작합니다.
     *  두 가지 경우를 고려합니다:
     *          find(2) (즉, N-2번째 계단에서 오는 경우)
     *          find(1) + arr[3] (즉, N-3번째 계단을 거쳐 N-1번째 계단을 거쳐 오는 경우)
     *       따라서 find(4)은 find(2)를 먼저 호출합니다.
     *
     * find(2) 호출:
     *  dp[2]는 초기화되어 있으므로 바로 반환합니다. (dp[2] = 30)
     *
     *  find(1) 호출:
     *  dp[1]는 초기화되어 있으므로 바로 반환합니다. (dp[1] = 10)
     *
     *  find(3) 호출:
     *      dp[3]이 null이므로 계산을 시작합니다.
     *      두 가지 경우를 고려합니다:
     *
     * find(1) (즉, N-2번째 계단에서 오는 경우)
     * find(0) + arr[2] (즉, N-3번째 계단을 거쳐 N-1번째 계단을 거쳐 오는 경우)
     *
     * 따라서 find(3)은 find(1)를 먼저 호출합니다.
     * find(1) 호출:
     *
     * dp[1]는 초기화되어 있으므로 바로 반환합니다. (dp[1] = 10)
     * find(0) 호출:
     *
     * dp[0]는 초기화되어 있으므로 바로 반환합니다. (dp[0] = 0)
     * 이 과정을 통해 dp[4], dp[3], dp[6]이 계산됩니다.
     */
    static int find(int N) {
        // 아직 탐색하지 않는 N번째 계단일 경우
        if(dp[N] == null) {
            dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
        }

        return dp[N];
    }
}
