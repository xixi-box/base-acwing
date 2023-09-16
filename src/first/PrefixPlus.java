package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

/**
 * 前缀和
 */
public class PrefixPlus {
    public static void main(String[] args) throws IOException {
        int N = 100010;
        int n, m;
        int a[] = new int[N], s[] = new int[N];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + a[i];
        }
        while (m != 0) {
            m--;
            int l, r;
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            System.out.println(s[r] - s[l - 1]);
        }

    }
}
