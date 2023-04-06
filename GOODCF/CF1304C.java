package GOODCF;

import java.io.*;
import java.util.StringTokenizer;

public class CF1304C {


//    Air Conditioner

    static void solve(long[][] a, int n, long m) {
        long l = m, r = m;
        boolean ok = true;
        for (int i = 1; i <= n; i++) {
            long d = a[i][0] - a[i-1][0];
            l -= d;
            r += d;
            l = Math.max(l, a[i][1]);
            r = Math.min(r, a[i][2]);
            if (l > r) {
                ok = false;
                break;
            }
        }
        if (ok)
            out.print("YES\n");
        else
            out.print("No\n");
    }

    public static void main(String[] args) throws IOException {
        int k = in.nextInt();
        while (k-- > 0) {
            int n = in.nextInt();
            long m = in.nextLong();       // init
            long[][] a = new long[n+1][3]; // t l r
            for (int i = 1; i <= n; i++) {
                a[i][0] = in.nextLong();
                a[i][1] = in.nextLong();
                a[i][2] = in.nextLong();
            }
            solve(a, n, m);
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
