package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//절사평균
public class Main6986 {
    static double trimmedMean; //절사 평균
    static double adjustedMean; //보정 평균


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Double[] point = new Double[N];
        for (int i = 0; i < N; i++) {
            point[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(point, Collections.reverseOrder());
    }
}
