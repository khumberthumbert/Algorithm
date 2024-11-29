package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3x3 크기의 사각형을 뒤집는 이유는 문제의 규칙 때문.
 * 두 배열을 비교해서 동일하게 만들어야 하는데, 오직 3x3 크기의 부분을 한 번에 뒤집을 수 있다는 제한이 있다.
 * 문제에서 두 배열을 비교할 때 단순히 어떤 값만 바꾸는 것이 아니라, 한 번에 3x3 크기의 부분을 뒤집는 방식으로만 변환이 가능하다.
 */

//백준 1080번 행렬
public class Main1080_2 {

    private static int[][] matA;
    private static int[][] matB;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();

        //split(" ")의 결과는 ["3", "4"] 이렇게 문자열 배열이 된다.
        int N = Integer.parseInt(NM.split(" ")[0]);
        int M = Integer.parseInt(NM.split(" ")[1]);


        matA = new int[N][M];
        matB = new int[N][M];

        //matA 입력
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                matA[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }
        //matB 입력
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                matB[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }
        /*
        변환 가능한지 확인.
        최소한의 크기가 3x3. 만약 N과 M 중 하나라도 3보다 작으면 3x3 크기의 사각형을 뒤집을 수 없다.
        그냥 두 배열이 같은지 확인한 다음에 같으면 0 출력, 다르면 -1 출력
         */
        if (N < 3 || M < 3) {
            if (isSameMatrix(N, M)) {
                System.out.println("0");
            } else {
                System.out.println("-1");
            }
            return;
        }

        int answer = 0;
        /*
        배열의 첫 번째 원소부터 차례대로 비교.
        만약 matA의 어떤 원소가 matB와 다르면, 그 위치에서 3x3 크기의 사각형을 뒤집는다.
        그리고 변환을 한 횟수를 하나씩 증가시킨다.
         */
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (matA[i][j] != matB[i][j]) {
                    changeSquareBoard(i, j);
                    answer++;
                }
            }
        }
        // 두 배열이 완전히 똑같은지 확인. 아직도 다르면 -1 출력.
        if (!isSameMatrix(N, M)) {
            answer = -1;
        }
        System.out.println(answer);
    }

    private static boolean isSameMatrix(int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matA[i][j] != matB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void changeSquareBoard(int startY, int startX){
        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                if (matA[i][j] == 1) {
                    matA[i][j] = 0;
                } else {
                    matA[i][j] = 1;
                }
            }
        }
    }
}
