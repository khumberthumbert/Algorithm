package problem.Algorithm;

import java.util.Scanner;

public class Main1051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열 크기 입력
        int N = sc.nextInt(); // 행
        int M = sc.nextInt(); // 열

        // 배열 입력 받기
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.next(); // 한 줄씩 입력받기
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0'; // 문자를 숫자로 변환
            }
        }

        // 가장 큰 정사각형 크기 찾기
        int maxSize = 1; // 최소 크기는 1x1 정사각형이므로 1로 초기화

        // 배열 탐색 및 DP 테이블 업데이트
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                // 현재 위치에서 만들 수 있는 최대 크기의 정사각형을 확인
                for (int k = 1; (i + k) < N && (j + k) < M; k++) {


                    // 네 꼭짓점이 같은 숫자인지 확인
                    if (arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j + k]) {

                        // 네 꼭짓점이 모두 같다면 정사각형의 크기를 계산
                        // k는 인덱스 차이만 나타내므로, 정사각형의 실제 변의 길이는 (k + 1) 이다. -> 실제 변의 길이는 시작점과 끝점 포함되어야 하기 때문에.
                        maxSize = Math.max(maxSize, (k + 1) * (k + 1));
                    }
                }
            }
        }

        // 가장 큰 정사각형의 크기 출력
        System.out.println(maxSize);

        sc.close();
    }
}


