package CT2;

import java.util.*;

class Point
{
    int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
/**
 * @program: Test
 * @ClassName Main17.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-11 00:08
 */
public class Main2 {

    // To find orientation of ordered triplet (p, q, r).
    // The function returns following values
    // 0 --> p, q and r are colinear
    // 1 --> Clockwise
    // 2 --> Counterclockwise
    /* Driver program to test above function */
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int curi = 0; curi < caseNum; curi++) {
            int pointSize = Integer.parseInt(cin.nextLine().trim());
            int[] pointArr = StringarrToIntarr(cin.nextLine().trim());
            Point[] points = new Point[pointSize];
            for(int j=0;j<pointSize;j++) {
                points[j] = new Point(pointArr[2*j],pointArr[2*j+1]);
            }
            convexHull(points, points.length);
        }
    }
    public static int orientation(Point p, Point q, Point r)
    {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0; // collinear
        return (val > 0)? 1: 2; // clock or counterclock wise
    }

    // Prints convex hull of a set of n points.
    public static void convexHull(Point points[], int n)
    {
        // There must be at least 3 points
        if (n < 3) return;

        // Initialize Result
        Vector<Point> hull = new Vector<Point>();

        // Find the leftmost point
        int l = 0;
        for (int i = 1; i < n; i++)
            if (points[i].x < points[l].x)
                l = i;

        // Start from leftmost point, keep moving
        // counterclockwise until reach the start point
        // again. This loop runs O(h) times where h is
        // number of points in result or output.
        int p = l, q;
        do
        {
            // Add current point to result
            hull.add(points[p]);

            // Search for a point 'q' such that
            // orientation(p, x, q) is counterclockwise
            // for all points 'x'. The idea is to keep
            // track of last visited most counterclock-
            // wise point in q. If any point 'i' is more
            // counterclock-wise than q, then update q.
            q = (p + 1) % n;

            for (int i = 0; i < n; i++)
            {
                // If i is more counterclockwise than
                // current q, then update q
                if (orientation(points[p], points[i], points[q])
                        == 2)
                    q = i;
            }

            // Now q is the most counterclockwise with
            // respect to p. Set p as q for next iteration,
            // so that q is added to result 'hull'
            p = q;

        } while (p != l); // While we don't come to first
        // point

        // Print Result
        if(hull.size()==0)
            System.out.println(-1);
        else{
            List<Point> resultList = new LinkedList<Point>(hull);
            Collections.sort(resultList,(P1,P2)->P1.x==P2.x?P1.y-P2.y:P1.x-P2.x);
            System.out.print(resultList.get(0).x+" "+resultList.get(0).y);
            for(int i=1;i<resultList.size();i++)
                System.out.print(", "+resultList.get(i).x+" "+resultList.get(i).y);
            System.out.println();
        }
    }
    /**
     * @title StringarrToIntarr
     * @description
     * @author Mr. jun
     * @param string
     * @return int[]
     * @throws
     * @updateTime 2019/10/10 9:20
     */
    public static int[] StringarrToIntarr(String string){
        String[] inputS = string.split(" ");
        int[] output = new int[inputS.length];
        for(int j=0;j<inputS.length;j++){
            output[j] = Integer.parseInt(inputS[j]);
        }
        return output;
    }
}