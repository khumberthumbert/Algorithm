package problem.Algorithm;

import java.util.Scanner;

//참외밭
public class Main2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1m²당 참외의 개수
        int k = sc.nextInt();

        // 방향과 변의 길이를 저장
        int[] directions = new int[6];
        int[] lengths = new int[6];

        for (int i = 0; i < 6; i++) {
            directions[i] = sc.nextInt();
            lengths[i] = sc.nextInt();
        }

        // 큰 직사각형의 면적 계산
        int maxWidth = 0, maxHeight = 0;
        for (int i = 0; i < 6; i++) {
            if (directions[i] == 1 || directions[i] == 2) { // 동쪽/서쪽
                maxWidth = Math.max(maxWidth, lengths[i]);
            } else if (directions[i] == 3 || directions[i] == 4) { // 남쪽/북쪽
                maxHeight = Math.max(maxHeight, lengths[i]);
            }
        }

        // 작은 직사각형의 면적 계산
        int smallWidth = 0, smallHeight = 0;
        for (int i = 0; i < 6; i++) {
            if (lengths[i] + lengths[(i + 2) % 6] == maxWidth) {
                smallHeight = lengths[(i + 1) % 6];
            }
            if (lengths[i] + lengths[(i + 2) % 6] == maxHeight) {
                smallWidth = lengths[(i + 1) % 6];
            }
        }

        // 전체 면적 = 큰 직사각형 면적 - 작은 직사각형 면적
        int bigArea = maxWidth * maxHeight;
        int smallArea = smallWidth * smallHeight;
        int totalArea = bigArea - smallArea;

        // 총 참외 개수 계산
        System.out.println(totalArea * k);
    }
}
