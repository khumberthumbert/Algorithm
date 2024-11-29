package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 카드 정렬하기
 */
public class Main1715 {
    public static void main(String[] args) throws IOException {
        //A+B 비교
        //고르는 순서에 따라 비교 횟수가 달라짐

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(sc.nextLong());
        }

        long num = 0;
        //우선순위 큐에 2개 이상 들어있어야 비교가 가능하다.
        while(pq.size() > 1) {
            long temp1 = pq.poll();
            long temp2 = pq.poll();

            num += temp1 + temp2;
            pq.add(temp1 + temp2); // 합한 묶음 다시 넣기
        }
        System.out.println(num);
    }
}
