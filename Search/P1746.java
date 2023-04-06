package Search;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1746 {


//    P1746 离开中山路 (AC)

    static final int N = 1001;
    static int[][] g = new int[N][N];
    static boolean[][] vis = new boolean[N][N];
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void solve(int n, int x1, int y1, int x2, int y2) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x1, y1, 0});
        vis[x1][y1] = true;
        while (q.size() > 0) {
            int[] p = q.poll();
            for (int[] d : dirs) {
                int nx = p[0] + d[0];
                int ny = p[1] + d[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || g[nx][ny] == 1) continue;
                if (!vis[nx][ny]) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny, p[2]+1});
                    if (nx == x2 && ny == y2) {
                        System.out.print(p[2]+1);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                g[i][j] = s.charAt(j) - '0';
            }
        }
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 =  sc.nextInt();
        int y2 = sc.nextInt();
        solve(n,x1-1, y1-1, x2-1, y2-1);
        sc.close();
    }

}
