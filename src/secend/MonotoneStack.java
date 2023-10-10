package secend;

import java.util.Scanner;

public class MonotoneStack {
    static int N = 100010;
    static int n;
    static int stk[] = new int[N], tt;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x;
            x = scanner.nextInt();
            //栈不是空的 栈顶元素大于x就把他删除
            while (tt != 0 && stk[tt] >= x) tt--;
            //找到至少有一个数
            if (tt != 0)
                System.out.printf("%d ", stk[tt]);
                //栈是空的
            else System.out.printf("-1 ");
            stk[++tt] = x;

        }
    }

}
