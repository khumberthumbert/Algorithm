package problem.Algorithm;

import java.util.Scanner;

public class Main7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력: 사람 수
        int n = sc.nextInt();
        int[][] people = new int[n][2]; // [몸무게, 키] 저장

        // 입력: 각 사람의 몸무게와 키
        for (int i = 0; i < n; i++) {
            people[i][0] = sc.nextInt(); // 몸무게
            people[i][1] = sc.nextInt(); // 키
        }

        // 각 사람의 덩치 등수 계산
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            ranks[i] = 1; // 기본 등수는 1
            for (int j = 0; j < n; j++) {
                if (i != j && people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
                    ranks[i]++; // 자신보다 몸무게와 키가 모두 큰 사람이 있으면 등수 증가
                }
            }
        }

        // 결과 출력
        for (int rank : ranks) {
            System.out.print(rank + " ");
        }
    }
}
