package UnionFind;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1656 {


//    P1656 炸铁路 (Tarjan求割边) AC

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer>[] g = new List[n+1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            g[a].add(b);
            g[b].add(a);
        }
        Tarjan tj = new Tarjan(g);
        tj.ans.sort((a, b) -> {
            if (a.get(0) == b.get(0)) {
                return a.get(1) - b.get(1);
            }
            return a.get(0) - b.get(0);
        });
        for (List<Integer> list : tj.ans) {
            out.println(list.get(0) + " " + list.get(1));
        }
        out.close();
    }


    static class Tarjan {
        int n;
        int time;
        int[] low;
        int[] dfn;
        List<Integer>[] g;
        List<List<Integer>> ans = new ArrayList<>(); // 存储桥边

        public Tarjan(List<Integer>[] g) {
            this.g = g;
            n = g.length;
            dfn = new int[n];
            low = new int[n];
            for (int i = 1; i <= n-1; i++) {
                if (dfn[i] == 0) {
                    dfs(i, -1);
                }
            }
        }

        void dfs(int u, int fa) {
            dfn[u] = low[u] = ++time;
            for (int v : g[u]) {
                if (dfn[v] == 0) {
                    dfs(v, u);
                    low[u] = Math.min(low[u], low[v]);
                    if (low[v] > dfn[u]) {  // 找桥边
                        ans.add(Arrays.asList(u, v));
                    }
                } else if (v != fa) {       // 搜索到父节点
                    low[u] = Math.min(low[u], dfn[v]);
                }
            }
        }
    }

    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static class InputReader {
        private StringTokenizer st;
        private BufferedReader bf;

        public InputReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
            st = null;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return bf.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
