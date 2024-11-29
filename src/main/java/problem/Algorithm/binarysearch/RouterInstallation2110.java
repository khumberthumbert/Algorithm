package problem.Algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RouterInstallation2110 {

    public static int[] house;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        house = new int[N];

        for(int i=0; i<N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int lo = 1; // 최소 거리가 가질 수 있는 최솟값
        /**
         * hi에 +1을 더하는 이유는 이진 탐색 과정에서 상한 값을 초과하는 첫 번째 지점으로 설정하기 위함이다.
         * 이진 탐색에서는 'mid' 값으로 가능한 최대 거리를 탐색하며, 이 때 사용되는 'hi' 값은 검사하려는 거리 범위의 상한 선이다.
         *
         * hi를 탐색 범위의 최소 가능 거리보다 1만큼 더 큰 값으로 설정하여, 이진 탐색이 최대 거리를 찾을 수 있는 범위를 확실히 포함하도록 하는 것.
         *
         * 이진 탐색의 상한 탐색(upper bound)에서는 'hi'가 검사할 값보다 1만큼 큰 값을 포함하도록 설정되므로, 이진 탐색이 끝났을 때'hi'가 실제로 가능한 최대 거리보다
         * 1 더 큰값을 가리키게 되어, 최종적으로 'lo-1'이 실제 최대거리를 나타내게 된다.
         *
         * 예제 [1, 2, 4, 8, 9]
         * house[N -1] - house[0] = 8
         * 여기에 1을 더해 hi를 9로 설정하면, 이진 탐색 과정에서 8이 최대 거리로도 고려될 수 있다.
         */
        int hi = house[N -1] - house[0] + 1; //최소 거리가 가질 수 있는 최대값

        while(lo < hi) { //upper bound 형식
            int mid = (hi + lo) / 2;

            /*
                mid 거리에 대해 설치 가능한 공유기 개수가 M 개수에 못 미치면 거리를 좁혀야 하기 때문에 hi를 줄인다.
             */
            if(canInstall(mid)<M) {
                hi = mid;
            } else{
                /**
                 * 설치 가능한 공유기 개수가 M 개수보다 크거나 같으면 거리를 벌리면서
                 * 최소거리가 가질 수 있는 최대 거리를 찾아낸다.
                 */
                lo = mid + 1;
            }
        }
        /*
        Upper Bound는 탐색 값을 초과하는 첫 번째 값을 가리키므로, 1을 빼준 값이 조건식을 만족하는 최대값이 된다.
         */
        System.out.println(lo - 1);
    }

    //distance에 대해 설치 가능한 공유기 개수를 찾는 메소드
    public static int canInstall(int distance) {

        //첫 번째 집은 무조건 설치한다고 가정
        int count = 1;
        int lastLocate = house[0];

        for(int i=1; i< house.length; i++) {
            int locate = house[i];

            /*
            현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가 최소거리 (distance)보다 크거나 같을 때
            공유기 설치 개수를 늘려주고 마지막 설치 위치를 갱신해준다.
             */
            if(locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;
    }
}
