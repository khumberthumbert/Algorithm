package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 단어수학
 */
public class Main1339 {

    static int N;
    static int[] arr = new int[26];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine(); // 한 줄을 읽어와서 str에 저장
            for (int j = 0; j < str.length(); j++) { //문자열의 길이만큼 반복하는 반복문
                char c = str.charAt(j);
                /**
                 * Math.pow() : 첫 번째 인자로 주어진 수(base)를 두 번째 인자(exponent)만큼 거듭제곱한 값을 계산하여 반환.
                 * 이 함수의 결과는 항상 'double'타입으로 반환하기에 적절한 타입 캐스팅이 필요.
                 * ex) double result = Math.pow(10, 2); // 10의 2승을 계산, 결과는 100.0
                 * ex) int intResult = (int) Math.pow(5, 3); // 5의 3승을 계산 후 정수형으로 캐스팅. 결과는 125
                 */
                /**
                 * 1. 'c' - 'A' : '가져온 문자에서 'A'를 빼면, 알파벳 순서에서 몇 번째인지를 나타내는 인덱스를 얻을 수 있다. ex) 'A'-'A' = 0, 'B'-'A' = 1
                 * 2. 'Math.pow(10, str.length() - 1 - j)' : 현재 문자의 위치에 따라 10의 거듭제곱으로 가중치를 계산
                 * str.length()-1은 가장 높은 자리수를 나타내고, '-j'는 왼쪽에서부터의 위치를 빼주어 해당 위치의 10의 거듭제곱 값을 구한다.
                 * 3. 'arr[c - 'A'] += : 계산된 가중치를 해당 문자의 배열 위치에 누적
                 */
                arr[c - 'A'] += (int) Math.pow(10, str.length() - 1 - j);
                /**
                 * ex)
                 * "WORD"라는 값을 입력해보았을 때
                 * 'W' -> arr['W'-'A'] += 1000
                 * 'O' -> arr['O'-'A'] += 100
                 * 'R' -> arr['R'-'A'] += 10
                 * 'D' -> arr['D'-'A'] += 1
                 */
            }
        }

        Arrays.sort(arr); // 가장 큰 값을 가진 원소가 배열의 끝에 위치하게 됨.

        /**
         * 가장 높은 가중치를 가진 알파벳 부터 가장 큰 숫자(9에서 시작)를 할당하고 그 결과를 통해 최대 수를 생성한다.
         */
        int num = 9;
        int turn = 25; // 알파벳 'Z' 해당.
        int ans = 0;
        while (arr[turn] != 0) { // 가중치가 0이 아닌 알파벳만 고려
            ans += arr[turn] * num; // arr[turn] -> 해당 알파벳의 총 가중치. num 은 그 알파벳에 할당될 숫자
            turn--; // 다음 낮은 인덱스로
            num--; // 다음 낮은 숫자로
        }
        System.out.println(ans);
        /**
         * ABC 예시
         * 배열 가중치 'A' -> 100, 'B' -> 10, 'C' -> 1
         * 최대 가치 할당 : 'A'에 9, 'B'에 8, 'C'에 7
         * 계산 9 x 100 + 8 x 10 + 7 x 1 = 900 + 8 + 7 = 987
         *
         * "WWWZZZAAA"예시 -> 모두 같은 가중치 이므로 숫자 할당 순서는 입력 순서에 의존하지 않음. 그렇기에 999888777 나옴
         */

        /**
         * 2
         * AAA
         * AAA
         * 입력 했을 떄. 한줄 111 한줄 111 '111 + 111' = 222
         * 배열 정렬 후 'A'에 대한 최고의 가중치(222)가 있으므로, 가장 큰 숫자인 '9'를 할당
         * -> 222 * 9 = 1998
         */
    }
}
