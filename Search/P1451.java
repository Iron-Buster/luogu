package Search;

import java.util.Scanner;

public class P1451 {


//    P1451 求细胞数量 (AC)

    static int[][] g = new int[110][110];

    static void solve(int n, int m) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] != 0) {
                    ++ans;
                    dfs(i, j, n, m);
                }
            }
        }
        System.out.print(ans);
    }

    static void dfs(int x, int y, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }
        if (g[x][y] != 0) {
            g[x][y] = 0;
            dfs(x+1, y, n, m);
            dfs(x-1, y, n, m);
            dfs(x, y+1, n, m);
            dfs(x, y-1, n, m);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                g[i][j] = s.charAt(j) - '0';
            }
        }
        solve(n, m);
    }
}
