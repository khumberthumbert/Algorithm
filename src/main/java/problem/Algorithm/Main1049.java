package problem.Algorithm;

import java.util.Scanner;

//기타줄
public class Main1049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt(); // 필요한 기타줄 개수
        int M = sc.nextInt(); // 브랜드 수

        //어떤 값이랑 비교해도 갱신될 수 있도록.
        int minPackage = Integer.MAX_VALUE; // 최소 패키지 가격
        int minIndividual = Integer.MAX_VALUE; // 최소 낱개 가격

        for (int i = 0; i < M; i++) {
            int packagePrice = sc.nextInt();
            int individualPrice = sc.nextInt();

            // 최소값 갱신
            minPackage = Math.min(minPackage, packagePrice);
            minIndividual = Math.min(minIndividual, individualPrice);
        }

        // 최소 비용 계산
        int costPackageOnly = ((N / 6) + 1) * minPackage; // 패키지로만 구매
        int costIndividualOnly = N * minIndividual; // 낱개로만 구매
        int costMixed = (N / 6) * minPackage + (N % 6) * minIndividual; // 혼합 구매

        // 최솟값 계산
        int minCost = Math.min(costPackageOnly, Math.min(costIndividualOnly, costMixed));

        // 결과 출력
        System.out.println(minCost);
    }
}
