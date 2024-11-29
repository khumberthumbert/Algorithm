package problem.Algorithm;

import java.util.Scanner;

//1072번 게임
public class Main1072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        long X = sc.nextLong(); // 총 게임 횟수
        long Y = sc.nextLong(); // 승리 횟수

        long Z = (Y * 100) / X; // 현재 승률 계산

        // 이미 승률이 99% 이상인 경우 더 이상 승률을 높일 수 없음
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        // 이분 탐색 범위 설정
        long left = 1;
        long right = 1_000_000_000;
        long result = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            // 새 승률 계산
            long newZ = ((Y + mid) * 100) / (X + mid);

            if (newZ > Z) {
                result = mid; // 승률이 변화했으면 결과 저장
                right = mid - 1; // 더 적은 승리 횟수를 탐색
            } else {
                left = mid + 1; // 더 많은 승리 횟수를 탐색
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
