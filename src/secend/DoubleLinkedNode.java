package secend;

public class DoubleLinkedNode {
    static int N = 100010;
    static int idx;
    static int e[] = new int[N];
    static int l[] = new int[N];
    static int r[] = new int[N];

    public static void init() {
        //0是左端点
        //1是右端点
        //第一个数从2开始
        l[0] = 1;
        r[1] = 0;
        idx = 2;
    }

    //右边插入
    public static void add(int k, int x) {
        e[idx] = x;
        //新节点的右边等于原来节点的右边
        r[idx] = r[k];
        //新节点的左边等于k,也就是原来的节点
        l[idx] = k;
        //旧节点的下一个节点的右边等于新节点
        l[r[k]] = idx;
        //旧节点的后面等于新节点
        r[k] = idx;
        idx++;
    }

    public static void remove(int k) {
        //左边的右节点直接等于源节点的右边
        r[l[k]] = r[k];
        //右边的左节点直接等于源节点的左边
        l[r[k]] = l[k];
    }

    public static void main(String[] args) {

    }
}