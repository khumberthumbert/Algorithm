package problem.Algorithm;

import java.util.*;

//촌수계산
public class Main2644 {
    /*
    향상된 for 구문
    - 배열이나 리스트의 각 요소를 직접 반복할 때 사용
    - 인덱스가 필요 없는 경우 간결하고 직관적이다.
     */

    /**
     * 촌수를 계산하는 메서드
     * @param n : 총 사람의 수
     * @param person1 : 첫 번째 사람(촌수를 계산하려는 사람)
     * @param person2 : 두 번째 사람(촌수를 계산하려는 상대)
     * @param relations : 부모와 자식 관계 목록.
     * @return
     */
    public static int findRelationship(int n, int person1, int person2, List<int[]> relations) {
        // 그래프를 인접 리스트로 구성

        //각 사람(정점)을 키로 하고, 그 사람과 연결된 사람들(이웃 노드들)을 리스트로 저장하는 그래프.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        //1번 부터 n번까지 각 사람에 대해 빈 리스트를 미리 생성
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 부모-자식 관계를 양방향 그래프로 연결 및 추가.
        for (int[] relation : relations) {
            int parent = relation[0];
            int child = relation[1];
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }

        // BFS 탐색을 위한 큐와 방문 배열
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n + 1]; // 방문 여부와 촌수를 함께 기록 (0이면 미방문)
        // 사람의 번호가 1부터 시작하기 때문에, 배열의 인덱스 1부터 사용할 수 있게 크기를 n+1로 설정

        // BFS 초기 설정
        queue.add(person1);
        visited[person1] = 1;  // 1을 방문 표시 (시작점에서의 촌수는 0이므로 1로 시작)

        // BFS 탐색
        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 탐색 중인 노드가 목표로 찾고자 하는 사람(person2)과 같은지 확인. 찾고자 하는 사람에 도달했는지 검사하는 부분.
            if (current == person2) {
                //visited[current] -> 몇 번째로 이 노드를 방문했는지 의미.
                //BFS는 시작 노드에서부터 각 노드까지의 최단 경로를 보장하므로, 이 값이 촌수다.
                //visited를 1부터 저장했기 때문에 실제 촌수는 이 값에서 1을 뺀 값을 반환한다.
                return visited[current] - 1;
            }


            // 현재 탐색 중인 current 노드와 연결된 모든 이웃 노드를 탐색. 이 이웃 노드들은 부모-자식 관계를 통해 연결된 다른 사람들.
            for (int neighbor : graph.get(current)) {
                if (visited[neighbor] == 0) {  // 미방문 노드
                    //이웃 노드를 탐색할 때, 이전 노드(current)에서 촌수를 1 증가 시킨다. 이 값은 탐색을 진행하며 누적되므로 촌수가 자연스럽게 계산된다.
                    visited[neighbor] = visited[current] + 1;
                    //방문하지 않은 이웃 노드를 큐에 추가한다. 이 노드는 나중에 탐색된다. 이렇게 하면 BFS 방식으로 탐색이 진행되며,
                    //큐에 추가된 노드들은 차례대로 방문된다.
                    queue.add(neighbor);
                }
            }
        }

        // 탐색이 끝나고도 경로를 찾지 못한 경우. -> 두 사람이 친척 관계가 없다
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt();  // 사람 수
        int person1 = sc.nextInt();  // 촌수를 계산할 첫 번째 사람
        int person2 = sc.nextInt();  // 촌수를 계산할 두 번째 사람
        int m = sc.nextInt();  // 부모-자식 관계의 수

        List<int[]> relations = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            relations.add(new int[]{parent, child});
        }

        // 촌수 계산
        int result = findRelationship(n, person1, person2, relations);
        System.out.println(result);
    }
}
