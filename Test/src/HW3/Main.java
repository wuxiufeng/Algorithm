package HW3;


import java.util.Scanner;

public class Main {

    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵

    /*
     * 创建图(用已提供的矩阵)
     *
     * 参数说明：
     *     vexs  -- 顶点数组
     *     edges -- 边数组
     */
    public Main(char[] vexs, char[][] edges) {

        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        int elen = edges.length;

        // 初始化"顶点"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++)
            mVexs[i] = vexs[i];

        // 初始化"边"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点
            int p1 = getPosition(edges[i][0]);
            int p2 = getPosition(edges[i][1]);

            mMatrix[p1][p2] = 1;
            mMatrix[p2][p1] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        while (caseNum > 0) {
            String[] input1 = cin.nextLine().trim().split(" ");
            int SIZE = Integer.parseInt(input1[0]);
            char BEGIN = input1[1].charAt(0);
            char[] input2 = StringToChaarr(cin.nextLine().trim());
            char[][] input3 = new char[SIZE][SIZE + 1];
            for (int i = 0; i < SIZE; i++)
                input3[i] = StringToChaarr(cin.nextLine().trim());

            int edgeNum = 0;
            for (int i = 0; i < SIZE; i++)
                for (int j = i + 1; j <= SIZE; j++)
                    if (input3[i][j] == '1')
                        edgeNum++;
            char[][] edgeIn = new char[edgeNum][2];
            edgeNum = 0;
            for (int i = 0; i < SIZE; i++)
                for (int j = i + 1; j <= SIZE; j++)
                    if (input3[i][j] == '1') {
                        edgeIn[edgeNum][0] = input2[i];
                        edgeIn[edgeNum][1] = input2[j - 1];
                        ++edgeNum;

                    }
            for (int i = 0; i < SIZE; i++) {
                if (input2[i] == BEGIN) {
                    input2[i] = input2[0];
                    input2[0] = BEGIN;
                    break;
                }
            }
            Main pG;
            pG = new Main(input2, edgeIn);
            pG.DFS();     // 深度优先遍历
//            pG.BFS();     // 广度优先遍历
            --caseNum;
        }
    }

    public static char[] StringToChaarr(String string) {
        String[] inputS = string.split(" ");
        char[] output = new char[inputS.length];
        for (int j = 0; j < inputS.length; j++) {
            output[j] = inputS[j].charAt(0);
        }
        return output;
    }

    /*
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for (int i = 0; i < mVexs.length; i++)
            if (mVexs[i] == ch)
                return i;
        return -1;
    }

    /*
     * 返回顶点v的第一个邻接顶点的索引，失败则返回-1
     */
    private int firstVertex(int v) {

        if (v < 0 || v > (mVexs.length - 1))
            return -1;

        for (int i = 0; i < mVexs.length; i++)
            if (mMatrix[v][i] == 1)
                return i;

        return -1;
    }

    /*
     * 返回顶点v相对于w的下一个邻接顶点的索引，失败则返回-1
     */
    private int nextVertex(int v, int w) {

        if (v < 0 || v > (mVexs.length - 1) || w < 0 || w > (mVexs.length - 1))
            return -1;

        for (int i = w + 1; i < mVexs.length; i++)
            if (mMatrix[v][i] == 1)
                return i;

        return -1;
    }

    /*
     * 深度优先搜索遍历图的递归实现
     */
    private void DFS(int i, boolean[] visited) {

        visited[i] = true;
        System.out.printf("%c ", mVexs[i]);
        // 遍历该顶点的所有邻接顶点。若是没有访问过，那么继续往下走
        for (int w = firstVertex(i); w >= 0; w = nextVertex(i, w)) {
            if (!visited[w])
                DFS(w, visited);
        }
    }

    /*
     * 深度优先搜索遍历图
     */
    public void DFS() {
        boolean[] visited = new boolean[mVexs.length];       // 顶点访问标记

        // 初始化所有顶点都没有被访问
        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;

//        System.out.printf("DFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i])
                DFS(i, visited);
        }
        System.out.printf("\n");
    }

    /*
     * 广度优先搜索（类似于树的层次遍历）
     */
    public void BFS() {
        int head = 0;
        int rear = 0;
        int[] queue = new int[mVexs.length];            // 辅组队列
        boolean[] visited = new boolean[mVexs.length];  // 顶点访问标记

        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;

//        System.out.printf("BFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.printf("%c ", mVexs[i]);
                queue[rear++] = i;  // 入队列
            }

            while (head != rear) {
                int j = queue[head++];  // 出队列
                for (int k = firstVertex(j); k >= 0; k = nextVertex(j, k)) { //k是为访问的邻接顶点
                    if (!visited[k]) {
                        visited[k] = true;
                        System.out.printf("%c ", mVexs[k]);
                        queue[rear++] = k;
                    }
                }
            }
        }
        System.out.printf("\n");
    }
}
