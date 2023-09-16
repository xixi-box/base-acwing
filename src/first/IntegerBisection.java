package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 整数二分
 */
public class IntegerBisection {


    public static void main(String[] args) throws IOException {
        int N = 100010;
        int n, m, q[] = new int[N];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q[i] = Integer.parseInt(st.nextToken());
        }
        while (m != 0) {
            m--;
            int x;
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (q[mid] >= x) r = mid;
                else l = mid + 1;
            }
            if (q[l] != x) System.out.println("-1 -1");
            else {
                System.out.printf("%d ", l);
                l = 0;
                r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (q[mid] <= x) l = mid;
                    else r = mid - 1;
                }
                System.out.println(l);
            }
        }
    }
}
