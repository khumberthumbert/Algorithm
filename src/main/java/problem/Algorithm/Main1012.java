package problem.Algorithm;

import java.util.Scanner;

//유기농 배추
public class Main1012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int m = sc.nextInt(); //가로
            int n = sc.nextInt(); //세로
            int k = sc.nextInt(); //배추 위치

            int[][] field = new int[n][m];
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[y][x] = 1; // 배추 위치 설정
            }

            int wormCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && field[i][j] == 1) {
                        dfs(field, visited, i, j, n, m); //배추 군집 탐색
                        wormCount++;
                    }
                }
            }
            System.out.println(wormCount); // 필요한 지렁이 수 출력
        }
        sc.close();
    }

    /*
    * x, y 현재 탐색 중인 위치의 좌표
    * n, m 배추밭의 크기, 각각 세로와 가로의 크기
    *
    * */
    static void dfs(int[][] field, boolean[][] visited, int x, int y, int n, int m) {
        visited[x][y] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if( nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && field[nx][ny] == 1) {
                dfs(field, visited, nx, ny, n, m);
            }
        }
    }
}
