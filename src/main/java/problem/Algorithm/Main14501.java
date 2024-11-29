package problem.Algorithm;

import java.util.Scanner;

public class Main14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력 받기
        int N = sc.nextInt(); // N일 동안 상담
        int[] T = new int[N+1]; // 각 상담에 걸리는 기간
        int[] P = new int[N+1]; // 각 상담의 보상
        int[] dp = new int[N + 2]; //dp[i] = i 번째 날부터 얻을 수 있는 최대 이익

        //상담 기간, 보상 입력 받기
        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt(); //상담 기간
            P[i] = sc.nextInt(); //상담 보상
        }

        //DP
        //입력이 다 주어져 있으니, 역순으로 돌려야 1일차에 결정할 때, 이미 며칠 후의 최대 이익을 알고 있으므로 최적의 결정 내리기 가능
        for (int i = N; i > 0; i--) {
            if (i + T[i] - 1 <= N) { //상담이 퇴사일을 넘지 않는다면.
                //상담을 할 수 있는 경우
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]); // P[i] + dp[i + T[i]] (현재 상담의 보상 + 상담이 끝난 이후 최대 수익)
            } else {
                dp[i] = dp[i + 1]; // 다음날의 최대 수익 그대로 끌고옴
            }
        }
        System.out.println(dp[1]);

        sc.close();
    }
}
