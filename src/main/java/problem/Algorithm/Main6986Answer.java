package problem.Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main6986Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }
        Arrays.sort(arr);
        //절사평균 구하기
        double sum = 0.0;
        for (int i = k; i < n - k; i++) { //앞뒤로 k개 만큼 빼고 합 구하기
            sum += arr[i];
        }
        //평균 구하기
        System.out.println(String.format("%.2f", sum/(n-k*2) + 1e-8));

        //보정평균 구하기
        for (int i = 0; i < k; i++) { //k만큼 좌우로 가까운 수 추가
            sum += arr[k];
            sum += arr[n-k-1];
        }
        System.out.println(String.format("%.2f", sum/n + 1e-8));
    }
}
