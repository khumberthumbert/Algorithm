package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//좋은 구간
public class Main1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int[] S = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < L; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());

        Arrays.sort(S);

        int start = 0;
        int end = 0;

        if(S[0] > n) end = S[0]; // 만약 n이 배열 S의 모든 값 보다 작다면, n과 S[0] 사이에 구간이 형성된다. 이 때 end는 S[0]으로 설정.
        else {
            for (int i = 0; i < L - 1; i++) {
                // 먼저 배열 S에서 n과 같은 값이 존재하는지 확인. 만약 n이 배열에 있으면, "좋은 구간"을 만들 수 없기 때문에 0을 출력하고 프로그램을 종료
                if (S[i] == n || S[i + 1] == n) {
                    System.out.println(0);
                    return;
                }
                //그렇지 않다면, n 보다 작은 값과 큰 값 사이의 구간을 찾는다. start는 n보다 작은 값 중 가장 큰 값, end는 n보다 큰 값 중 가장 작은 값이다.
                if (S[i] < n && S[i + 1] > n) {
                    start = S[i];
                    end = S[i+1];
                }
            }
        }
        //n - start - 1 : n보다 작은 값들 중에서 구간을 형성할 수 있는 경우의 수.
        //end - n - 1 : n보다 큰 값들 중에서 구간을 형성할 수 있는 경우의 수.
        //(n - start - 1) * (end - n - 1): start와 end 사이에서 서로 다른 구간을 형성할 수 있는 경우의 수.

        int ans = n-start-1 + end-n-1 + (n-start-1)*(end-n-1);

        System.out.println(ans);
    }
}
