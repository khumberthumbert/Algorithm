package problem.Algorithm;
import java.util.Scanner;

public class Main1080 {
    // 3x3 부분 행렬 뒤집기
    public static void flip(int[][] matrix, int x, int y) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[x + i][y + j] = 1 - matrix[x + i][y + j];
            }
        }
    }

    // 행렬 A를 행렬 B로 바꾸는 최소 연산 횟수 계산
    public static int solve(int N, int M, int[][] A, int[][] B) {
        int operations = 0;

        // 3x3 부분 행렬을 뒤집을 수 있는 범위는 (N-2, M-2)까지
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                // A와 B가 다르면 3x3 부분 행렬을 뒤집는다
                if (A[i][j] != B[i][j]) {
                    flip(A, i, j);
                    operations++;
                }
            }
        }

        // 연산이 끝난 후 A와 B가 같은지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    return -1; // A를 B로 바꿀 수 없는 경우
                }
            }
        }

        return operations; // 연산 횟수 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        // 행렬 A 입력
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }

        // 행렬 B 입력
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                B[i][j] = line.charAt(j) - '0';
            }
        }

        // 문제 해결
        int result = solve(N, M, A, B);

        // 결과 출력
        System.out.println(result);

        sc.close();
    }
}
