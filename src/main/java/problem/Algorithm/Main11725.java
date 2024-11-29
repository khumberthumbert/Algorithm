package problem.Algorithm;

import java.util.*;

public class Main11725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 그래프를 인접 리스트로 표현
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        // 부모 노드를 저장할 배열
        int[] parent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        // BFS를 이용해 부모 노드 찾기
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // 루트 노드 1부터 시작
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                if (!visited[next]) {
                    parent[next] = current;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        // 2번 노드부터 N번 노드까지 부모 노드 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }
}

