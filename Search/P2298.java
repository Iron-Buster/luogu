package Search;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2298 {

//    P2298 Mzc和男家丁的游戏 (AC)

    static char[][] g = new char[2010][2010];
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void solve(int x1, int y1, int x2, int y2, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x1, y1, 0});
        g[x1][y1] = '#';
        while (q.size() > 0) {
            int[] p = q.poll();
            for (int[] d : dirs) {
                int nx = p[0] + d[0];
                int ny = p[1] + d[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (g[nx][ny] != '#') {
                    g[nx][ny] = '#';
                    if (nx == x2 && ny == y2) {
                        System.out.print(p[2]+1);
                        return;
                    }
                    q.offer(new int[]{nx, ny, p[2]+1});
                }
            }
        }
        System.out.print("No Way!");
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'd') {
                    x2 = i; y2 = j;
                } else if (s.charAt(j) == 'm') {
                    x1 = i; y1 = j;
                }
                g[i][j] = s.charAt(j);
            }
        }
        solve(x1, y1, x2, y2, n, m);
        sc.close();
    }
}
