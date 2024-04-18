package problem.Algorithm.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JewelThief1202 {

    //보석 관련 정보 클래스
    static class jewel implements Comparable<jewel> {
        int value, weight; //가치 및 무게

        public jewel(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
        //보석 클래스 정렬 관련

        @Override
        public int compareTo(jewel o) {
            if(this.weight == o.weight)
                return o.value - this.value;
            return this.weight - o.weight;
        }
    }
    static int N, K; // N -> 보석 갯수, K -> 가방 갯수
    static long answer = 0;
    static int[] bag; // 가방 무게 저장 배열
    static jewel[] jewels; // 보석 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bag = new int[K];
        jewels = new jewel[N];
        //보석 입력값 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels[i] = new jewel(V, M); // 보석의 무게 'M'과 가치 'V'를 입력받아 'jewels' 배열에 저장
        }
        //가방 입력값 저장
        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());
            bag[i] = C;
        }

        /**
         * 가방과 보석을 오름차순으로 정렬하는 것은 그리디 알고리즘의 핵심이다.
         *  가방을 오름차순으로 정렬하는 이유:
         *  1. 최소 무게 가방부터 시작 -> 각 가방에 대해 담을 수 있는 보석의 최대 가치를 구할 수 있다.
         *  2. 효율적인 보석 선택 -> 무게가 작은 가방부터 처리함으로써, 남아 있는 보석들 중에서 해당 가방에 맞는 보석을 더 쉽게 선택할 수 있다.
         *
         *  보석을 오름차순으로 정렬하는 이유:
         *  1. 가치가 높은 보석 우선 선택 -> 각 가방에 대해 가능한 한 가치가 높은 보석을 우선적으로 고려할 수 있다.
         *  2. 탐색 범위 최소화 -> 무게가 낮은 보석부터 시작하여 탐색하면, 각 가방의 무게 한도에 맞춰 탐색해야 하는 보석의 수를 최소화 할 수 있다.
         *  3. 우선순위 큐의 효율적 사용 -> 언제든지 가장 가치가 높은 보석을 빠르게 선택할 수 있다.
         */

        /**
         * 그리디 알고리즘에서 우선순위 큐를 사용하는 이유?
         * 1. 가장 좋은 선택을 빠르게 찾기 -> 그리디 알고리즘의 핵심 원칙은 '매 선택 시점에서 최적의 해를 선택한다'는 것.
         * 2. 자동 정렬 기능 -> 우선순위 큐는 내부적으로 힙 자료구조를 사용하여 요소들을 자동 정렬한다.
         * 3. 효율성
         * 4. 동적 업데이트 용이
         */

        Arrays.sort(bag); // 가방 오름차순 정렬
        Arrays.sort(jewels); // 보석 정렬


        //PriorityQueue 생성 및 내림차순 정렬로 설정
        /**
         * PriorityQueue를 내림차순으로 정렬하는 이유
         * 최대 가치 우선 선택 -> 우선 순위 큐가 내림차순으로 정렬되어 있기 때문에, 큐의 맨 앞에는 항상 가장 가치가 높은 보석이 위치하게 됨
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        //가방 무게가 낮은 것부터 탐색.
        //각 가방에 대해, 현재 가방의 무게보다 가벼운 보석들을 'pq'변수에 추가한다.
        //그 중에서 가장 가치가 높은 보석을 선택하여 'answer'에 더한다.
        for (int i = 0, j = 0; i < K; i++) { // 가방 순회 반복문
            while(j<N) { // 보석 탐색 반복문 -> 모든 보석을 검사하거나, 현재 가방의 무게보다 무거운 보석을 만나면 종료
                if(bag[i] < jewels[j].weight) //다음 보석부터 가방의 무게보다 클 때
                    break;
                //현재 가방의 무게 한도 내에서 보석을 담을 수 있다면, 해당 보석을 추가.
                pq.add(jewels[j++].value); //가방에 보석을 넣을 수 있을 때
            }
            //가장 가치 있는 보석 선택. 현재 가방에 담을 수 있는 보석들 중에서 가장 가치가 높은 보석은 pq 맨위에 있음.
            // 따라서 pq.poll()을 호출하여 이 보석을 꺼내고, 그 가치를 answer에 더한다.
            if(!pq.isEmpty())
                answer += pq.poll();
        }


        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
