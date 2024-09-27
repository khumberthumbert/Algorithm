package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 18429번 : 근손실
public class Main18429 {

    static int N, K;
    static int[] A;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        //순열 생성 및 조건 체크
        permute(0, 500); // 첫 번째 날 중량 500으로 시작

        System.out.println(result);
    }
    //재귀
    public static void permute(int count, int currentWeight) {
        //모든 키트를 사용한 경우
        if(count == N) {
            // 조건을 만족하는 경우의 수 증가.
            result++;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // 방문하지 않은 키트를 선택
                int nextWeight = currentWeight + A[i] - K; // 다음날의 중량 계싼
                if (nextWeight >= 500) { //중량이 500 이상인 경우에만 진행
                    visited[i] = true; //현재 키트를 선택
                    permute(count + 1, nextWeight);//다음 키트를 재귀 호출
                    visited[i] = false; //백트래킹
                }
            }
        }
    }
}
