package problem.Algorithm;

import java.util.Scanner;

/**
 * 어린왕자 1004번 문제. 수학.
 */
public class Main1004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < length; i++) {
            String base = sc.nextLine();

            int xStart = Integer.parseInt(base.split(" ")[0]);
            int yStart = Integer.parseInt(base.split(" ")[1]);

            int xEnd = Integer.parseInt(base.split(" ")[2]);
            int yEnd = Integer.parseInt(base.split(" ")[3]);

            int through = 0;

            int count = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < count; j++) {
                String circle = sc.nextLine();

                int x = Integer.parseInt(circle.split(" ")[0]);
                int y = Integer.parseInt(circle.split(" ")[1]);
                int r = Integer.parseInt(circle.split(" ")[2]);

                boolean hasStartContain = hasContain(xStart, yStart, x, y, r);
                boolean hasEndContain = hasContain(xEnd, yEnd, x, y, r);

                //해당 행성이 출발 혹은 도착점 중 하나만을 포함할 경우
                if (!(hasStartContain && hasEndContain) && (hasStartContain || hasEndContain)) {
                    through++;
                }
            }
            System.out.println(through);
        }
        sc.close();
    }

    /**
     *
     * @param xo : 출발/도착점의 x좌표
     * @param yo : 출발/도착점의 y좌표
     * @param x : 행성의 x 좌표
     * @param y : 행성의 y 좌표
     * @param r : 행성의 반지름
     * @return : 출발/도착점 포함 여부
     */
    private static boolean hasContain(int xo, int yo, int x, int y, int r) {
        return Math.sqrt(Math.pow(xo - x, 2) + Math.pow(yo - y , 2)) < r;
    }
}
