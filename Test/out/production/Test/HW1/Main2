#include <stdio.h>
        #include <memory.h>


        #define MAX_LEN 2005

        int nRow, nCol;

        int matrix[MAX_LEN][MAX_LEN]; //原数据
        int heights[MAX_LEN][MAX_LEN];//用这个数组来描述 histogram，其中heights[i]表示 以第i行走底的histogram，里面的元素表示对应列的高度
        struct Node
        {
        int height;
        int position;


        Node(int _height, int _from): height(_height), position(_from)
        {
        }
        Node()
        {

        }
        };
        int max(int a, int b)
        {
        return a>b ? a : b;
        }
//自己实现堆栈，因为stl的栈太慢了，会超时
        int topID;
        Node stack[MAX_LEN];
//栈对应的操作
        void push(const Node & t)
        {
        stack[topID++] = t;
        }
        const Node top()
        {
        return stack[topID-1];
        }
        void pop()
        {
        topID--;
        }



        int GetArea(int iRow) //用单调栈来枚举其中以 某一行做底的 histogram 所得到的最大矩形面积。
        {
        topID = 0;
        push(Node(-1, 0));


        int i;
        int area, maxArea = 0;

        int position, height;

        for( i = 0; i <= nCol; i++)
        {
        position = i + 1;

        if(i == nCol)
        {
        height = -1;

        }
        else
        {
        height = heights[iRow][i];
        }

        Node t(height, position);

        while(top().height > height)
        {
        t = top();
        pop();

        area = (position - t.position) * t.height;
        if(area > maxArea)
        {
        maxArea = area;
        }

        }
        push(Node(height, t.position));

        }
        return maxArea;

        }
        int main()
        {
        int caseNum;
        scanf("%d", &caseNum);
        for(int curi=0; curi<caseNum; curi++)
        {
        scanf("%d%d", &nRow, &nCol);
        int i,j;
        int b;
        for( i = 0; i < nRow; i++)
        {
        for( j = 0; j < nCol; j++)
        {
        scanf("%d", &matrix[i][j]);

        }

        }
        //求histogram，求的时候，如果以 i 行为底边，j对应的高度是 从i 到 最高连续的1 的数量
        memcpy(heights, matrix, sizeof(matrix));
        for( i = 0; i < nCol; i++)
        {
        for( j = 1; j < nRow; j++)
        {
        if(heights[j][i] != 0)
        {
        heights[j][i] += heights[j-1][i];
        }
        }
        }

        int maxArea = 0, Area;
        for( i = 0; i < nRow; i++)
        {
        Area = GetArea(i);
        maxArea = max(maxArea, Area);
        }
        printf("%d\n", maxArea);

        }
        }