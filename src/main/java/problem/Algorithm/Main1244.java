package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스위치 개수 입력
        int N = Integer.parseInt(br.readLine());
        int[] switches = new int[N + 1];  // 스위치 번호가 1번부터 시작하므로 크기를 N+1로 설정

        // 스위치 상태 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        // 학생 수 입력
        int studentCount = Integer.parseInt(br.readLine());

        // 학생들의 정보 처리
        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());  // 1: 남학생, 2: 여학생
            int number = Integer.parseInt(st.nextToken());  // 학생이 받은 숫자

            if (gender == 1) {
                // 남학생: 자신이 받은 수의 배수인 스위치를 모두 반전
                for (int j = number; j <= N; j += number) {
                    switches[j] = switches[j] == 1 ? 0 : 1;
                }
            } else if (gender == 2) {
                // 여학생: 자신이 받은 번호를 중심으로 좌우 대칭인 범위를 반전
                int left = number;
                int right = number;

                // 좌우 대칭이면서 범위 내일 때 스위치 상태 반전
                /*
                left와 right가 같은 경우와 다른 경우를 구분하여 처리. 만약 left == right라면 한 번만 반전해야 하고, 다르다면 좌우 각각을 반전해야 함
                 */
                while (left >= 1 && right <= N && switches[left] == switches[right]) {
                    switches[left] = switches[left] == 1 ? 0 : 1;
                    if (left != right) {
                        switches[right] = switches[right] == 1 ? 0 : 1;
                    }
                    left--;
                    right++;
                }
            }
        }

        // 결과 출력 (20개씩 출력)
        for (int i = 1; i <= N; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) {
                System.out.println(); // 20개마다 줄바꿈
            }
        }
    }
}

