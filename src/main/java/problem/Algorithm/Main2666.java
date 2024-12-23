package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
문제가 이해가 안됐는데, 검색해보니. 열려 있는 벽장의 수가 무조건 2개 라는 점이 핵심이었다.
항상 두 개의 문이 열려 있는 벽장에서 특정 순서대로 물건을 꺼낼 때, 문을 최소한으로 이동시키는 방법을 찾는 문제.
 */
public class Main2666 {

    static List<Integer> opens;
    static int[] target; // 물건을 꺼내야 하는 순서를 저장하는 배열.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");

        opens = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            opens.add(Integer.parseInt(line[i]));
        }

        int test = Integer.parseInt(br.readLine()); // 물건을 꺼낼 횟수를 입력받음.


        // 물건을 꺼내야 하는 문 번호를 순서대로 저장.
        target = new int[test];
        for (int i = 0; i < test; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }
        //최소 이동 계산. 초기 상태에서는 열려 있는 두 문 opens.get(0)과 opens.get(1)이 인자로 전달.
        System.out.println(solve(0, opens.get(0), opens.get(1)));
    }

    //최소 이동 계산.
    /*
    a, b : 현재 열려 있는 두 개의 문의 번호.
    종료 조건 : 모든 물건을 꺼낸 경우, 이동거리는 더 이상 계산할 필요가 없으므로 0을 반환.
     */
    static int solve(int cnt, int a, int b) {
        if(cnt == target.length) return 0;

        /*
        cnt -> 현재 꺼낼 차례의 물건 인덱스.
        target[cnt] : 이번에 꺼내야 할 물건이 위치한 문 번호를 나타냄.
         */
        int tmp1 = Math.abs(a-target[cnt]); // 첫 번째 문을 이동시키는 거리
        int tmp2 = Math.abs(b-target[cnt]); // 두 번째 문을 이동시키는 거리

        //이후 min을 통해 두 문 중 더 적게 움직이는 경우를 선택.
        return Math.min(tmp1 + solve(cnt + 1, b, target[cnt]),
                        tmp2 + solve(cnt + 1, a, target[cnt]));
    }
}
