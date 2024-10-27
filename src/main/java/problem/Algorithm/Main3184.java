package problem.Algorithm;

//양
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3184 {
    static int R, C;
    static char[][] yard;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        yard = new char[R][C];
        visited = new boolean[R][C];

        // 마당 입력 받기
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                yard[i][j] = line.charAt(j);
            }
        }

        int totalSheep = 0;
        int totalWolves = 0;

        // 마당의 모든 칸을 순회하며 BFS 탐색
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && (yard[i][j] == 'o' || yard[i][j] == 'v' || yard[i][j] == '.')) {
                    int[] result = bfs(i, j);
                    totalSheep += result[0];
                    totalWolves += result[1];
                }
            }
        }

        // 결과 출력
        System.out.println(totalSheep + " " + totalWolves);
    }

    // BFS 함수
    static int[] bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int sheepCount = 0;
        int wolfCount = 0;

        // 시작 위치가 양인지 늑대인지 확인
        if (yard[x][y] == 'o') sheepCount++;
        if (yard[x][y] == 'v') wolfCount++;

        // BFS 탐색
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currX = current[0];
            int currY = current[1];

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];

                // 마당 범위 내에 있고, 울타리가 아니며, 방문하지 않은 경우
                if (newX >= 0 && newX < R && newY >= 0 && newY < C && !visited[newX][newY] && yard[newX][newY] != '#') {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});

                    // 양과 늑대의 수를 카운트
                    if (yard[newX][newY] == 'o') sheepCount++;
                    if (yard[newX][newY] == 'v') wolfCount++;
                }
            }
        }

        // 양과 늑대의 수 비교 후 결과 반환
        if (sheepCount > wolfCount) {
            return new int[]{sheepCount, 0}; // 양이 더 많으면 늑대는 모두 쫓겨남
        } else {
            return new int[]{0, wolfCount}; // 늑대가 더 많거나 같으면 양이 모두 잡아먹힘
        }
    }
}

