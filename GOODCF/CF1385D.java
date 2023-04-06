package GOODCF;

import java.io.*;
import java.util.StringTokenizer;

public class CF1385D {

//    a-Good String

    static char[] ss = new char[200001];

    static int solve(int l, int r, char c) {
        if (l == r) return ss[l] != c ? 1 : 0;
        int a = 0, b = 0;
        int mid = (l + r) >> 1;
        for (int i = l; i <= mid; i++) {
            if (ss[i] != c) a++;
        }
        for (int i = mid + 1; i <= r; i++) {
            if (ss[i] != c) b++;
        }
        a += solve(mid + 1, r, (char) (c+1));
        b += solve(l, mid, (char) (c+1));
        return Math.min(a, b);
    }

    public static void main(String[] args) throws IOException {
        int k = in.nextInt();
        while (k-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            for (int i = 1; i <= n; i++) {
                ss[i] = s.charAt(i-1);
            }
            int ans = solve(1, n, 'a');
            out.println(ans);
        }
        out.close();
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
