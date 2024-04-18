package problem.Algorithm.graph;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열

        arr = new char[N][M]; // 실제 타일의 모양
        visited = new boolean[N][M]; //타일 방문 했는지 안했는지

        for (int i = 0; i < N; i++) {
            String str = br.readLine(); // 문자열로 ㅡㅡㅢㅣㅣㅣ 입력 받을 테니까. 변수에 저장한 후
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j); // 하나씩 char[][]배열에 저장
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) continue; // 방문했다면 바로 j++

                if(arr[i][j] == '-') dfs(i, j, true);
                else dfs(i, j, false);

                cnt++; //새로운 타일 그룹을 발견 할 때 증가 됨.
            }
        }

        System.out.println(cnt);

    }

    private static void dfs(int i, int j, boolean row) {
        visited[i][j] = true; // 현재 타일 위치 방문한 것으로.
        if(row) { // 수평타일 검색
            j++; // 오른쪽으로 연속될 수 있는지 확인하기 위해 열 인덱스 j를 1 증가. 이 부분 중요.
            if(j<M && arr[i][j] == '-') dfs(i, j, true);
        }
        else {
            i++; // 아래로 연속될 수 있는지 확인하기 위해 행 인덱스 i를 1 증가. 중요.
            if(i<N && arr[i][j] != '-') dfs(i, j, false);
        }

    }

}
