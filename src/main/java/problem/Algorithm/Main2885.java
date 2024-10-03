package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2885 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int size = 1; //사야하는 가장 작은 초콜릿 크기
        int count = 0; // 최소 몇 번 초콜릿 쪼개야 하는지

        // 사이즈 구하기
        while(size < K) size *=2;
        System.out.print(size + " ");

        // count 구하기
        while(K > 0) {
            if(K >= size) {
                K -= size; //주어진 초콜릿 크기를 size 만큼 빼서 초콜릿 쪼갬
            } else {
                size /= 2;
                count++;
            }
        }
        System.out.println(count);
    }
}
