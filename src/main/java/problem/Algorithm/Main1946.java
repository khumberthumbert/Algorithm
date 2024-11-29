package problem.Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 신입사원 1946번
 */

class Grade implements Comparable<Grade> {
    int a;
    int b;

    Grade(int a, int b) {
        this.a = a;
        this.b = b;
    }

    /**
     * 어느 시점에 compareTo 메서드가 실행 될까? 라는 의문점이 있었는데, Collections.sort(list) 메서드가 호출될 때 사용된다고 함.
     * Collections.sort는 리스트를 정렬하기 위해 각 요소 간의 순서를 결정해야 하는데, 이 때 'Grade' 클래스가 'Comparable' 인터페이스를
     * 구현하고 있으며, 'compareTo' 메서드를 오버라이드하고 있으므로, 정렬과정에서 'compareTo' 메서드를 사용하여 'Grade' 객체들의 순서를 결정하게 된다.
     */
    @Override
    public int compareTo(Grade o) {
        if (this.a > o.a) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class Main1946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            ArrayList<Grade> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                list.add(new Grade(a, b));
            }
            /** 역시 예제를 들어야 확실히 이해가 된다.
             * // 예제: 서류 점수와 면접 점수를 가진 지원자 리스트
             * ArrayList<Grade> list = new ArrayList<>();
             * list.add(new Grade(1, 4)); // 서류 1등, 면접 4등
             * list.add(new Grade(2, 3)); // 서류 2등, 면접 3등
             * list.add(new Grade(3, 2)); // 서류 3등, 면접 2등
             * list.add(new Grade(4, 1)); // 서류 4등, 면접 1등
             *
             * Collections.sort(list); // 서류 점수 기준 오름차순 정렬
             *
             * int ans = 1; // 서류 1등은 무조건 통과
             * int min = list.get(0).b; // 면접 점수 최소값 초기화 (4)
             *
             * for (int i = 1; i < list.size(); i++) { // 서류 2등부터 시작
             *     if (list.get(i).b < min) { // 이전의 최소 면접 점수보다 낮으면 통과
             *         ans++;
             *         min = list.get(i).b; // 최소 점수 갱신
             *     }
             * }
             *
             * System.out.println(ans); // 결과 출력
             */

            /**
             * 1. 정렬 호출
             * Collections.sort(list); 가 호출되면 list에 있는 Grade 객체들을 서류 점수('a'필드)를 기준으로 오름차순으로 정렬한다.
             * 정렬 과정에서 'compareTo' 메서드가 여러 번 호출되어 'Grade' 객체 간의 순서를 결정한다.
             *
             * 2. 정렬 알고리즘
             * Collections.sort는 내부적으로 정렬 알고리즘을 사용하며, 이 과정에서 'compareTo'메서드를 사용하여 두 'Grade' 객체를 비교한다.
             * 'compareTo' 메서드는 this.a와 o.a를 비교하여 반환 값에 따라 정렬 순서를 결정한다.
             */
            Collections.sort(list); // 서류 점수 기준 오름차순 정렬

            int ans = 1; // 서류 1등은 무조건 통과
            int min = list.get(0).b; // 서류 점수 1등의 면접 점수
            for (int i = 1; i < N; i++) { // 서류 2등 부터 시작
                if (list.get(i).b < min) { // 이전의 최소 면접 점수보다 낮으면 통과
                    ans++;
                    min = list.get(i).b; // 최소 점수 갱신 -> 면접 순위가 이전까지 본 지원자들 중에서 가장 낮은 지원자들을 찾아내기 위함.
                }
            }
            System.out.println(ans);
        }
    }
}
