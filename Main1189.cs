using System;
using System.ComponentModel.Design;

namespace StudyC_
{
    class Main1189
    {
        static int R, C, K; // R : 행 , C : 열 , K : 목표 거리
        static char[,] map; //지도 정보를 저장하는 2차원 배열 char 타입.
        static bool[,] visited; 

        /*
         방향 벡터
         */
        static int[] dx = { -1, 1, 0, 0 }; //상 하 좌 우 이동
        static int[] dy = { 0, 0, -1, 1 };

        static int count = 0; // 목표를 달성한 경로의 수 저장.

        static void Main(string[] args)
        {
            //입력 받기
            string[] firstLine = Console.ReadLine().Split();
            R = int.Parse(firstLine[0]);
            C = int.Parse(firstLine[1]); 
            K = int.Parse(firstLine[2]);

            map = new char[R, C];
            visited = new bool[R, C];

            for (int i = 0; i < R; i++)
            {
                string line = Console.ReadLine();
                for (int j = 0; j < C; j++)
                {
                    map[i, j] = line[j];
                }
            }

            visited[R - 1, 0] = true; // 시작점(우하단) 방문처리
            DFS(R - 1, 0, 1); // (R-1, 0) :시작 좌표. 1은 현재까지 이동한 거리이다.

            Console.WriteLine(count);
        }

        /*
         * 현재 위치에서 상하좌우로 이동한다.
         * 방문하지 않았고 이동 가능한 위치(.)인 경우에만 이동한다.
         * 조건에 맞지 않으면 백트래킹으로 되돌아간다.
         */
        static void DFS(int x, int y, int distance)
        {
            
            /*집 (좌상단)에 도달했으며, 거리가 K인 경우. 경우의 수 증가.
             * 현재 좌표가 (0, C-1) (집의 위치)이고, 이동 거리가 정확히 K라면 count를 증가시킨다.
             * return : 조건이 충족되면 재귀호출 종료.
             */
            if (x == 0 && y == C -1 && distance == K)
            {
                count++;
                return;
            }

            //4방향 탐색
            for ( int i = 0; i< 4; i++)
            {
                //현재 좌표에서 방향 벡터를 더해 새로운 좌표를 계산한다.
                int nx = x + dx[i];
                int ny = y + dy[i];

                /*
                 * 유효성 검사
                 * nx >= 0 && nx < R && ny >= 0 && ny < C : 새로운 좌표가 지도 범위를 벗어나지 않았는지 확인한다.
                 * !visited[nx, ny] : 해당 위치를 이미 방문하지 않았는지 확인한다.
                 * map[nx, ny] == '.' : 새로운 좌표가 이동 가능한 위치인지 확인한다.
                 */
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx, ny] && map[nx, ny] == '.')
                {
                    visited[nx, ny] = true;
                    DFS(nx, ny, distance + 1);
                    visited[nx, ny] = false; //백트래킹 -> 한 경로를 완료한 후 다른 경로를 탐색할 수 있도록 상태를 되돌린다.
                }
            }
        }
    }
}
