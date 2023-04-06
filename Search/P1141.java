package Search;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1141 {

    // TODO
    static int[][] g = new int[1010][1010];
    static int[][] mp = new int[1010][1010];
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] vis = new boolean[1010][1010];

    static void solve(int n) {
        for (boolean[] v : vis) {
            Arrays.fill(v, false);
        }
        for (int[] m : mp) {
            Arrays.fill(m, 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mp[i][j] += dfs(i, j, n);
            }
        }
    }

    static int dfs(int x, int y, int n) {
        int cnt = 0;
        vis[x][y] = true;
        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || g[x][y] == g[nx][ny]) continue;
            if (!vis[nx][ny]) {
                cnt = 1 + dfs(nx, ny, n);
            }
        }
        vis[x][y] = false;
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                g[i][j] = s.charAt(j) - '0';
            }
        }

        solve(n);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            list.add(mp[x][y]);
        }
        for (int ans : list) {
            System.out.println(ans);
        }
        sc.close();
    }

    static BufferedReader ins = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(ins);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }

    public static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    public static String nextString() throws IOException {
        in.nextToken();
        return in.sval;
    }
}
