package problem.Algorithm;

import java.util.Scanner;

public class Main2631 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //어린이 수

        int[] arr = new int[N]; // 현재 줄 서 있는 어린이들 순서
        int[] dp = new int[N]; //LIS(최장 증가 부분 수열) 계산을 위한 배열

        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt(); //어린이 순서 입력
        }

        int max = 0; //LIS 최대 길이
        for(int i=0;i<N;i++) {
            dp[i] = 1; // 현재 위치의 LIS 최소 길이는 1 (자기 자신만 퐘)
            for(int j=0;j<i;j++) {
                //현재 위치까지 증가 수열을 찾는 조건
                if(arr[j]<arr[i] && dp[j]+1>dp[i]) {
                    dp[i] = dp[j]+1; // 증가 수열의 길이를 갱신
                    max = Math.max(max, dp[i]); //LIS 최대 길이 갱신
                }
            }
        }

        System.out.println(N-max); // 전체 어린이 수에서 움직이지 않아도 되는 어린이(LIS의 길이)를 빼면, 움직여야 하는 어린이 수가 된다.
    }
}
