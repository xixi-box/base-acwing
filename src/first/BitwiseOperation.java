package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 二进制里1的个数
 */
public class BitwiseOperation {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        while (n != 0) {
            n--;
            int x;

            x = Integer.parseInt(st.nextToken());
            int res = 0;
            while (x != 0) {
                x -= lowbit(x);//每次减去x的最后一位1
                res++;
            }
            System.out.printf("%d ", res);
        }
    }

    public static int lowbit(int x) {
        //返回最后一位1的位置
        return x & -x;
    }
}
