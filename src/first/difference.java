package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 差分
 */
public class difference {
    static int N = 100010;
    static int n, m;
    static int a[] = new int[N], b[] = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            insert(i, i, a[i]);
        }
        while (m != 0) {
            m--;
            int l, r, c;
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            insert(l, r, c);
        }
        for (int i = 1; i <= n; i++) {
            b[i] += b[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d ", b[i]);
        }
    }

    public static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }
}
