package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//상근이의 여행
public class Main9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int T = Integer.parseInt(st.nextToken().trim());
        for(int t=0;t<T;t++) {
            int N, M;
            st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            for(int m=0;m<M;m++)
            {
                st = new StringTokenizer(br.readLine());
            }
            System.out.println(N-1);
        }
    }
}
