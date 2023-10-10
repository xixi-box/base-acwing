package secend;

import java.util.Scanner;

@SuppressWarnings("all")
public class SingleLinkedNode {
    static int N = 100010;
    //idx 用到了哪个点
    //head指向头结点的下标,也就是头结点的下一个值 head的意思是头结点的下一个值相当于[]
    //e[i]表示节点i的值
    //ne[i]表示节点i的下一个值是多少
    static int head, idx, e[] = new int[N], ne[] = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m;
        m = scanner.nextInt();
        init();
        while (m-- > 0) {
            int k, x;
            char op;
            op = scanner.next().charAt(0);
            if (op == 'H') {
                x = scanner.nextInt();
                addHead(x);
            } else if (op == 'D') {
                k = scanner.nextInt();
                //如果是删除头结点,就把头结点下标的下一个指向头结点
                if (k == 0) head = ne[head];
                else remove(k - 1);
            } else {
                k = scanner.nextInt();
                x = scanner.nextInt();
                add(k - 1, x);
            }
        }
        for (int i = head; i != -1; i = ne[i]) {
            System.out.printf("%d ", e[i]);
        }
        System.out.println();
    }

    public static void init() {
        head = -1;
        idx = 0;
    }
    //增加在头结点后面
    public static void addHead(int x) {
        //将待插入节点保存
        e[idx] = x;

        ne[idx] = head;
        head = idx++;
    }

    //在k之后加入x
    public static void add(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }

    public static void remove(int k) {
        ne[k] = ne[ne[k]];
    }
}
