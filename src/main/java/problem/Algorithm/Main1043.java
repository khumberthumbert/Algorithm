package problem.Algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

public class Main1043 {

    static int[] parents; // 모든 사람의 부모 노드 정보를 담는 배열. union-find 자료구조에서 사용된다.
    static List<Integer> eList; // 진실을 아는 사람들의 목록
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int m = Integer.parseInt(st.nextToken()); // 파티 수

        //parents 배열을 초기화해서 각 사람이 자기 자신을 부모로 가지도록 설정
        parents = new int[n+1];
        for(int i=1; i<n+1; i++) {
            parents[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int en = Integer.parseInt(st.nextToken()); // en -> 진실을 아는 사람 수
        eList = new ArrayList<>();
        if(en == 0) { // 진실을 아는 사람 없을 경우
            System.out.println(m);
        } else {
            for(int i=0; i<en; i++) {
                eList.add(Integer.parseInt(st.nextToken())); // 진실을 아는 사람들을 담는 리스트
            }
        }

        // 각 인덱스에 따라 다양한 리스트를 관리해야 할 때 유용한 방식.
        // 배열을 생성할 때는 명시적으로 타입을 지정해줘야하고, 배열의 각 요소를 초기화 해줘야 한다. 그래서 이렇게 작성한다.
        List<Integer>[] partyList = new ArrayList[m];
        for(int i=0; i<m; i++) {
            partyList[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) { // 파티 탐색 반복문
            st = new StringTokenizer(br.readLine());
            int pn = Integer.parseInt(st.nextToken()); // 파티에 참석한 사람 수

            /**
             * 첫 번째 참가자를 기준으로 나머지 참가자와 'union' 함수를 사용하여 연결한다.
             *
             * 내부반복문에서 'x'를 기준으로 다른 모든 참가자'y'와 'union'을 수행하여 모든 사람이 하나의 집합에 포함되도록 한다.
             */
            int x = Integer.parseInt(st.nextToken()); // 첫 번째 사람 번호
            partyList[i].add(x);
            for (int j = 1; j < pn; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x,y);
                partyList[i].add(y);
            }
        }

        int cnt = 0; // 진실을 모르는 사람들만 있는 파티의 수를 세기 위한 카운터
        for (int i = 0; i < m; i++) { // 모든 파티를 반복하며 확인
            boolean flag = true; // 각 파티에 대해, 초기에는 이 파티가 '안전'하다고 가정 (진실을 모르는 사람들만 있다고 가정)
            for (int num : partyList[i]) { // 파티에 참석하는 각 사람에 대해 반복
                if (eList.contains(find(parents[num]))) { // 만약 이 사람의 그룹 대표가 진실을 아는 사람이라면
                    flag = false; // 이 파티는 '안전'하지 않음
                    break; // 더 이상 다른 사람을 확인할 필요 없이 반복을 중단
                }
            }
            if(flag) { // 만약 이 파티가 '안전'하다면
                cnt++; // 카운터를 증가
            }
            System.out.println(cnt); // 현재까지 '안전한' 파티의 수 출력
        }

        }

    //대표(뿌리 노드)찾기
    static int find(int x) {
            if(parents[x] == x) return x; //x가 자신이 루트일 경우. x를 반환
            return find(parents[x]); // x의 부모를 따라가며 루트를 재귀적으로 찾는다.
    }

    static void union(int x, int y) {
            int rx = find(x); // 뿌리노드 찾기 이 뿌리노드가 리더 역할을 한다.
            int ry = find(y);

        /**
         *  'y'의 대표가 진실을 아는 사람의 리스트에 포함되어 있는지 검사
         *  -> 만약 포함되어 있다면 'rx'와 'ry'를 교환. 이 부분은 진실을 아는 사람을 더 높은 우선순위로 두어 그룹의 대표로 설정하기 위함
         */
        if (eList.contains(ry)) {
                int tmp = rx;
                rx = ry;
                ry = tmp;
            }
        //y의 대표('ry)'의 부모를 'x'의 대표('rx')로 설정함으로써 두 그룹을 하나로 합친다.
        //이로써 'x'와 'y' 그리고 그들이 속한 그룹 전체가 하나의 집합으로 통합된다.
            parents[ry] = rx;
    }
}
