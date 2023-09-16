package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 浮点数二分
 */
public class FloatingPointBinary {
    public static void main(String[] args) throws IOException {
        double x;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Double.parseDouble(st.nextToken());
        double l = 0, r = x;
        while ((r - l) > 1e-8) {
            double mid = (l + r) / 2;
            if (mid * mid >= x) r = mid;
            else l = mid;
        }
        System.out.printf("%f", l);
    }
}
