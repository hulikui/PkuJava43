/** @important
 * 最多有多少个点在一条直线上

 给出二维平面上的n个点，求最多有多少点在同一条直线上。

 样例
 给出4个点：(1, 2), (3, 6), (0, 0), (1, 3)。

 一条直线上的点最多有3个。
 */
/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     * 遍历 求 斜率 k 注意相同的点
     */
    public int maxPoints(Point[] points) {
        if(points == null) return 0;
        if(points.length <=1) return points.length;
        int max = 0;
        for(int i=0; i<points.length; i++){
            double k = 0;
            int samePoint = 0;
            int tempMax = 1;
            Map<Double> map = new HashMap<>();
            for(int j = i+1; j<points.length; j++){
                if(points[j].x == points[i].x && points[j].y == points[i].y){
                    samePoint++;
                    continue;
                }else if(points[j].x != points[i].x){
                    k = (double)(points[j].y - points[i].y)/(points[j].x - points[i].x);
                }else{
                    k = double.MIN_VALUE;
                }
                int num = 2;
                if(map.containsKey(k)){
                    num = map.get(k);
                    map.set(k, ++num);
                }else{
                    map.put(k, num);
                }
                tempMax = Math.max(tempMax, num);
            }
            max = Math.max(tempMax + samePoint, max);
        }
        return max;
    }
}