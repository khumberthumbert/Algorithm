package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

//폴리오미노

/**
 * 스트림 상에서의 처리는 배열 형태가 아닌 문자열로 이루어집니다.
 * 하지만 그 과정에서 각 부분이 개별적으로 처리된 후 다시 합쳐지기 때문에 구분이 가능합니다.
 * 배열이 아니라 스트림이기 때문에 중간 과정에서 각 부분을 독립적으로 처리하고, 최종적으로 다시 하나의 문자열로 만들어줍니다.
 */
public class Main1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();

        // .을 기준으로 나눈 문자열들을 처리
        /**
         * split("\\.", -1) : 마지막에 빈 문자열이 있어도 그것을 포함하도록 -1 플래그를 사용.
         * .XX.처럼 양 끝에 .이 있는 경우를 처리하기 위함.
         */
        String result = Arrays.stream(x.split("\\.", -1)) // .으로 나누되 마지막 빈 요소까지 포함
                //.map : 변환 작업을 수행, 변환된 스트림은 새로운 스트림을 반환
                .map(s -> {
                    int len = s.length();
                    StringBuilder sb = new StringBuilder();

                    // AAAA로 채울 수 있는 만큼 채우기
                    while (len >= 4) {
                        sb.append("AAAA");
                        len -= 4;
                    }

                    // 2자리 남으면 BB로 채우기
                    if (len == 2) {
                        sb.append("BB");
                    } else if (len != 0) {
                        // 길이가 2로 나누어 떨어지지 않으면 불가능 (-1)
                        return "-1";
                    }

                    return sb.toString();
                })
                //.collect : 스트림의 결과를 특정한 자료구조로 변환할 때 사용 -> 최종작업
                .collect(Collectors.joining("."));  // 다시 .을 기준으로 합침
        /*
                Collectors.toList() → 리스트로 변환
                Collectors.toSet() → 집합(Set)으로 변환
                Collectors.joining() → 문자열로 연결
                Collectors.toMap() → 맵으로 변환
        */


        // 결과가 불가능한 문자열이면 -1 출력, 아니면 결과 출력
        if (result.contains("-1")) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }

    }
}
